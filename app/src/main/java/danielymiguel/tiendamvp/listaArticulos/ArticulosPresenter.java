package danielymiguel.tiendamvp.listaArticulos;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.util.List;

import danielymiguel.tiendamvp.AppContexto;
import danielymiguel.tiendamvp.modelos.Articulo;
import danielymiguel.tiendamvp.modelos.api.ApiRest;
import danielymiguel.tiendamvp.modelos.api.RetrofitAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticulosPresenter implements ArticulosContract.Presenter {
    private ArticulosContract.View articulosView;
    private ApiRest apiRest;
    //private ArticulosMock apiRest;

    public ArticulosPresenter(ArticulosContract.View noticiasView) {
        this.articulosView = noticiasView;
        this.apiRest = RetrofitAPI.getAPIRest();
    }

    @Override
    public void cargaDatos() {
        apiRest.obtenerArticulos().enqueue(new Callback<List<Articulo>>() {
            @Override
            public void onResponse(Call<List<Articulo>> call, Response<List<Articulo>> response) {
                if (response.isSuccessful()){
                    if (response.body().size() == 0){
                        Toast.makeText(AppContexto.getContexto(), "Datos vacíos", Toast.LENGTH_SHORT).show();
                    } else {
                        // Paso la respuesta que es el array de artículos
                        articulosView.mostrarArticulos(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Articulo>> call, Throwable t) {
                Toast.makeText(AppContexto.getContexto(), "Error al obtener los datos", Toast.LENGTH_SHORT).show();
            }
        });
    }



    //Método para comprobar si tiene conexion
    @Override
    public boolean compruebaConexion(Context context) {

        boolean connected = false;

        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        // Recupera todas las redes (tanto móviles como wifi)
        NetworkInfo[] redes = connec.getAllNetworkInfo();

        for (int i = 0; i < redes.length; i++) {
            // Si alguna red tiene conexión, se devuelve true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                connected = true;
            }
        }
        return connected;
    }

}