package danielymiguel.tiendamvp.modelos;

import android.util.Log;
import java.util.List;
import danielymiguel.tiendamvp.modelos.api.ApiRest;

public class ArticulosRepository implements ArticulosDataSource {

    private ApiRest api = new ApiRest();
    private static ArticulosRepository INSTANCIA = null;
    private List<Articulo> listaArticulos = null;

    public static ArticulosRepository getInstance(){
        if (INSTANCIA == null){
            INSTANCIA = new ArticulosRepository();

        }
        return INSTANCIA;
    }

    @Override
    public void getArticulos(final CargaArticulosCallback callback) {
//        if (listaArticulos == null){
            api.getArticulos(new CargaArticulosCallback() {
                @Override
                public void onArticulosCargadas(List<Articulo> noticias) {
                    listaArticulos = noticias;
                    callback.onArticulosCargadas(noticias);
                    Log.v("Errores::", "ArticulosRepository::Articulos cargados con petición");
                }

                @Override
                public void onArticulosError() {
                    callback.onArticulosError();
                }
            });
//        }else{
//            callback.onArticulosCargadas(listaArticulos);
//            Log.v("Errores::", "ArticulosRepository::Articulos cargados sin petición.");
//        }
    }

    @Override
    public void getArticulo(int posicion, CargaArticuloCallback callback) {
        if (posicion < listaArticulos.size()){
            callback.onArticuloCargada(listaArticulos.get(posicion));
        }else{
            callback.onArticuloError();
        }
    }

    @Override
    public void putArticulo(String codigo, String nombre, String categoria, String stock, String precio, String imagen, String descripcion) {
        api.putArticulo(codigo, nombre, categoria, stock, precio, imagen, descripcion);
    }

    @Override
    public void postArticulo(String codigo, String nombre, String categoria, String stock, String precio, String imagen, String descripcion) {
        api.postArticulo(codigo, nombre, categoria, stock, precio, imagen, descripcion);
    }

    @Override
    public void deleteArticulo(String codigo) {
        api.deleteArticulo(codigo);
    }


}
