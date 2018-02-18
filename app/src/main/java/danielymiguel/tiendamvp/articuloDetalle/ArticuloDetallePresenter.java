package danielymiguel.tiendamvp.articuloDetalle;

import android.util.Log;

import danielymiguel.tiendamvp.modelos.Articulo;
import danielymiguel.tiendamvp.modelos.api.ApiRest;
import danielymiguel.tiendamvp.modelos.api.RetrofitAPI;


//public class ArticuloDetallePresenter implements ArticuloDetalleContract.Presenter {

//    private ArticuloDetalleContract.View articuloVista;
//    private ApiRest apiRest;
//
//    public ArticuloDetallePresenter(ArticuloDetalleContract.View articuloVista) {
//        this.articuloVista = articuloVista;
//        this.apiRest = RetrofitAPI.getAPIRest();
//    }

//    @Override
//    public void cargaArticulo(int posicion) {
//        apiRest.getArticulo(posicion, new ArticulosDataSource.CargaArticuloCallback() {
//            @Override
//            public void onArticuloCargada(Articulo articulo) {
//                Log.v("Errores::", "ArticuloDetallePresenter::onArticuloCargada");
//                articuloVista.mostrarArticulo(articulo);
//            }
//
//            @Override
//            public void onArticuloError() {
//                Log.e("Errores::", "ArticuloDetallePresenter::onArticuloError");
//            }
//        });
//    }

//    @Override
//    public void borrarArticulo(String codigo) {
//        apiRest.deleteArticulo(codigo);
//    }
//}
