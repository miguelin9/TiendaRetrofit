package danielymiguel.tiendamvp.actualizarArticulo;

import android.widget.Toast;

import danielymiguel.tiendamvp.AppContexto;
import danielymiguel.tiendamvp.modelos.Articulo;
import danielymiguel.tiendamvp.modelos.api.ApiRest;
import danielymiguel.tiendamvp.modelos.api.RetrofitAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticuloPUTPresenter implements ArticuloPUTContract.Presenter {

    private ApiRest apiRest;

    public ArticuloPUTPresenter(ArticuloPUTContract.View articuloPUTView) {
        this.apiRest = RetrofitAPI.getAPIRest();
    }

    @Override
    public void actualizarArticulo(Articulo articulo) {
        apiRest.actualizarArticulo(articulo.getCodigo(), articulo).enqueue(new Callback<Articulo>() {
            @Override
            public void onResponse(Call<Articulo> call, Response<Articulo> response) {
                Toast.makeText(AppContexto.getContexto(), "Actualizado correctamente", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Articulo> call, Throwable t) {
                Toast.makeText(AppContexto.getContexto(), "Error al actualizar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}