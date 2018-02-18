package danielymiguel.tiendamvp.articuloDetalle;

import danielymiguel.tiendamvp.modelos.Articulo;


public interface ArticuloDetalleContract {
    interface View {
        void mostrarArticulo(Articulo articulo);
    }

    interface Presenter {
        void cargaArticulo(int posicion);
        void borrarArticulo(String codigo);
    }
}