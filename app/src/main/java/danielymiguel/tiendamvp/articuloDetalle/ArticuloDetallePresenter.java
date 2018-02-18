package danielymiguel.tiendamvp.articuloDetalle;

import android.util.Log;

import danielymiguel.tiendamvp.modelos.Articulo;
import danielymiguel.tiendamvp.modelos.ArticulosDataSource;
import danielymiguel.tiendamvp.modelos.ArticulosRepository;


public class ArticuloDetallePresenter implements ArticuloDetalleContract.Presenter {

    private ArticuloDetalleContract.View articuloVista;
    private ArticulosRepository articulosRepository;

    public ArticuloDetallePresenter(ArticuloDetalleContract.View articuloVista) {
        this.articuloVista = articuloVista;
        this.articulosRepository = ArticulosRepository.getInstance();
    }

    @Override
    public void cargaArticulo(int posicion) {
        articulosRepository.getArticulo(posicion, new ArticulosDataSource.CargaArticuloCallback() {
            @Override
            public void onArticuloCargada(Articulo articulo) {
                Log.v("Errores::", "ArticuloDetallePresenter::onArticuloCargada");
                articuloVista.mostrarArticulo(articulo);
            }

            @Override
            public void onArticuloError() {
                Log.e("Errores::", "ArticuloDetallePresenter::onArticuloError");
            }
        });
    }

    @Override
    public void borrarArticulo(String codigo) {
        articulosRepository.deleteArticulo(codigo);
    }
}
