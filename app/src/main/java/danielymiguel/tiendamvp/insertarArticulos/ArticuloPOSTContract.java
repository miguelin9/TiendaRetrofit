package danielymiguel.tiendamvp.insertarArticulos;

import android.widget.Spinner;

import danielymiguel.tiendamvp.modelos.Articulo;

public interface ArticuloPOSTContract {

    // La vista tendrá un método que comprobará el articulo que hay
    // para no duplicarlo.

    interface View {
        boolean comprobarCampos();
        void insertarCategorias();
    }

    // El presentador será el encargado de enviar la petición.
    interface Presenter {
        void insertarArticulo (Articulo articulo);
    }
}
