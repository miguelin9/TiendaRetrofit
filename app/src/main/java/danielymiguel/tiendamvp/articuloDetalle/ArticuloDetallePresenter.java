package danielymiguel.tiendamvp.articuloDetalle;

import android.util.Log;
import android.widget.Toast;

import java.util.List;

import danielymiguel.tiendamvp.AppContexto;
import danielymiguel.tiendamvp.modelos.Articulo;
import danielymiguel.tiendamvp.modelos.api.ApiRest;
import danielymiguel.tiendamvp.modelos.api.RetrofitAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ArticuloDetallePresenter implements ArticuloDetalleContract.Presenter {

    private ArticuloDetalleContract.View articuloVista;
    private ApiRest apiRest;

    public ArticuloDetallePresenter(ArticuloDetalleContract.View articuloVista) {
        this.articuloVista = articuloVista;
        this.apiRest = RetrofitAPI.getAPIRest();
    }

    @Override
    public void cargaArticulo(int codigo) {
        Log.e("Errores", "A cargar artículo con código: " + codigo);
        apiRest.obtenerArticulo(codigo).enqueue(new Callback<List<Articulo>>() {
            @Override
            public void onResponse(Call<List<Articulo>> call, Response<List<Articulo>> response) {
                articuloVista.mostrarArticulo(response.body().get(0));
            }

            @Override
            public void onFailure(Call<List<Articulo>> call, Throwable t) {
                Toast.makeText(AppContexto.getContexto(), "Error al obtener artículo", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void borrarArticulo(int codigo) {
//        apiRest.borrarArticulo(codigo);
    }
}
