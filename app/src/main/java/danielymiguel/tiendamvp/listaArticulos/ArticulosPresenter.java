package danielymiguel.tiendamvp.listaArticulos;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.List;

import danielymiguel.tiendamvp.modelos.Articulo;
import danielymiguel.tiendamvp.modelos.ArticulosDataSource;
import danielymiguel.tiendamvp.modelos.ArticulosRepository;

public class ArticulosPresenter implements ArticulosContract.Presenter {
    private ArticulosContract.View noticiasView;
    private ArticulosRepository articulosRepository;
    //private ArticulosMock articulosRepository;

    public ArticulosPresenter(ArticulosContract.View noticiasView) {
        this.noticiasView = noticiasView;
        this.articulosRepository = ArticulosRepository.getInstance();
        //this.articulosRepository = new ArticulosMock();
    }

    @Override
    public void cargaDatos() {
        articulosRepository.getArticulos(new ArticulosDataSource.CargaArticulosCallback() {
            @Override
            public void onArticulosCargadas(List<Articulo> articulos) {
                noticiasView.mostrarArticulos(articulos);
            }

            @Override
            public void onArticulosError() {
                noticiasView.mostrarError();
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