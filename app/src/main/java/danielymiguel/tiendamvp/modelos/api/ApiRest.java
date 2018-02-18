package danielymiguel.tiendamvp.modelos.api;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import danielymiguel.tiendamvp.AppContexto;
import danielymiguel.tiendamvp.modelos.Articulo;
import danielymiguel.tiendamvp.modelos.ArticulosDataSource;

public class ApiRest implements ArticulosDataSource{

    final String urlArticulos = "http://52.47.123.57:5000/articulos/"; // IP del server
//        String urlArticulos = "http://192.168.0.164:3000/articulos"; // IP de Dani

    @Override
    public void getArticulos(final CargaArticulosCallback callback) {
//        Log.v("Errores","Prueba1");
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, urlArticulos, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        Log.v("Errores","Prueba2");
                        // respuesta del get devuelve un array json, a implementar
                        //Uso Gson para deserializar el array automaticamente
                        Gson gson = new Gson();
//                        Log.v("Errores","Prueba3");
                        Type type = new TypeToken<List<Articulo>>(){}.getType();
//                        Log.v("Errores","Prueba4");
                        List<Articulo> articulos = gson.fromJson(response.toString(), type);
//                        Log.v("Errores","Prueba5");
                        Log.v("Errores::", "ApiRest::Antes de cargar articulos");
                        callback.onArticulosCargadas(articulos);
                        Log.v("Errores::", "ApiRest::Articulos Cargados");
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.e("Errores","ApiRest::getArticulos::onErrorResponse");
                    }
                });

        MiSinglentonVolley.getInstance(AppContexto.getContexto()).getRequestQueue().add(jsonArrayRequest);
    }

    @Override
    public void getArticulo(int posicion, CargaArticuloCallback callback) {
        // actualmente se obtiene con la posicion de la lista, implementado en ArticulosRepository
    }

    @Override
    public void putArticulo(final String codigo,final String nombre,final String categoria,final String stock,final String precio,final String imagen,final String descripcion) {
        // Petición PUT
        StringRequest putRequest = new StringRequest(Request.Method.PUT, urlArticulos + codigo,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Toast.makeText(AppContexto.getContexto(), "Artículo actualizado", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(AppContexto.getContexto(), "Error al actualizar", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("nombre", nombre);
                params.put("categoria", categoria);
                params.put("stock", stock);
                params.put("precio", precio);
                params.put("foto", imagen);
                params.put("descripcion", descripcion);

                return params;
            }

        };

        MiSinglentonVolley.getInstance(AppContexto.getContexto()).getRequestQueue().add(putRequest);
    }

    @Override
    public void postArticulo(final String codigo, final String nombre, final String categoria, final String stock, final String precio, final String imagen, final String descripcion) {
        // Petición POST
        StringRequest postRequest = new StringRequest(Request.Method.POST, urlArticulos,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Toast.makeText(AppContexto.getContexto(), "Artículo creado correctamente", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(AppContexto.getContexto(), "Error al insertar, posible código existente", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("codigo", codigo);
                params.put("nombre", nombre);
                params.put("categoria", categoria);
                params.put("stock", stock);
                params.put("precio", precio);
                params.put("foto", imagen);
                params.put("descripcion", descripcion);

                return params;
            }

        };

        MiSinglentonVolley.getInstance(AppContexto.getContexto()).getRequestQueue().add(postRequest);
    }

    @Override
    public void deleteArticulo(String codigo) {
        StringRequest delete = new StringRequest(Request.Method.DELETE, urlArticulos + codigo,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Toast.makeText(AppContexto.getContexto(), "Borrado correctamente", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error.
                        Toast.makeText(AppContexto.getContexto(), "Error al borrar", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        MiSinglentonVolley.getInstance(AppContexto.getContexto()).getRequestQueue().add(delete);
    }
}


