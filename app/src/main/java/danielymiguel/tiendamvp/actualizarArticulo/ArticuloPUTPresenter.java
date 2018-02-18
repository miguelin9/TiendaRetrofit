package danielymiguel.tiendamvp.actualizarArticulo;

import danielymiguel.tiendamvp.modelos.api.ApiRest;
import danielymiguel.tiendamvp.modelos.api.RetrofitAPI;

public class ArticuloPUTPresenter implements ArticuloPUTContract.Presenter {

    private ApiRest apiRest;

    public ArticuloPUTPresenter(ArticuloPUTContract.View articuloPUTView) {
        this.apiRest = RetrofitAPI.getAPIRest();
    }

    @Override
    public void actualizarArticulo(String codigo, String nombre, String categoria, String stock, String precio, String imagen, String descripcion) {
//        apiRest.actualizarArticulo(Articulo articulo);
    }
}