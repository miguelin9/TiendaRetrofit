package danielymiguel.tiendamvp.articuloDetalle;

import danielymiguel.tiendamvp.modelos.Articulo;


public interface ArticuloDetalleContract {
    interface View {
        void mostrarArticulo(Articulo articulo);
    }

    interface Presenter {
        void cargaArticulo(int codigo);
        void borrarArticulo(int codigo);
    }
}