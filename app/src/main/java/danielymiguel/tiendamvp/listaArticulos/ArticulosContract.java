package danielymiguel.tiendamvp.listaArticulos;

import android.content.Context;

import java.util.List;

import danielymiguel.tiendamvp.modelos.Articulo;

/**
 * Interfaz para desacoplar el activity y el presentador
 * También llamado interactor o contract
 *
 */

public interface ArticulosContract {

    interface View {
        void mostrarArticulos(List<Articulo> articulos);
        void mostrarError();
    }

    interface Presenter {
        void cargaDatos();
        boolean compruebaConexion(Context context);
    }

}
