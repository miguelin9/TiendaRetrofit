package danielymiguel.tiendamvp.modelos;

import java.util.List;

/**
 * Created by matinal on 8/01/18.
 */

public interface ArticulosDataSource {

    void getArticulos(CargaArticulosCallback callback);
    void getArticulo(int posicion, CargaArticuloCallback callback);
    void putArticulo(final String codigo,final String nombre,final String categoria,final String stock,final String precio,final String imagen,final String descripcion);
    void postArticulo(final String codigo,final String nombre,final String categoria,final String stock,final String precio,final String imagen,final String descripcion);
    void deleteArticulo(final String codigo);

    interface CargaArticulosCallback {
        void onArticulosCargadas(List<Articulo> articulos);
        void onArticulosError();
    }

    interface CargaArticuloCallback {
        void onArticuloCargada(Articulo articulo);
        void onArticuloError();
    }

}
