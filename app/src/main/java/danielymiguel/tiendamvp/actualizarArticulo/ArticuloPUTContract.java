package danielymiguel.tiendamvp.actualizarArticulo;

import danielymiguel.tiendamvp.modelos.Articulo;

/**
 * Interfaz para desacoplar el activity y el presentador
 * También llamado interactor o contract
 *
 */

public interface ArticuloPUTContract {

    // La vista tendrá un método que comprobará los campos.
    interface View {
        void comprobarCampos();
    }

    // El presentador será el encargado de enviar la petición.
    interface Presenter {
        void actualizarArticulo (String codigo, String nombre, String categoria, String stock, String precio, String imagen, String descripcion);
    }

}
