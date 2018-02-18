package danielymiguel.tiendamvp.insertarArticulos;


import android.widget.Toast;

import danielymiguel.tiendamvp.AppContexto;
import danielymiguel.tiendamvp.modelos.Articulo;
import danielymiguel.tiendamvp.modelos.api.ApiRest;
import danielymiguel.tiendamvp.modelos.api.RetrofitAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticuloPOSTPresenter implements ArticuloPOSTContract.Presenter {

    private ApiRest apiRest;

    public ArticuloPOSTPresenter(ArticuloPOSTContract.View articuloPOSTView) {
        this.apiRest = RetrofitAPI.getAPIRest();
    }

    @Override
    public void insertarArticulo(Articulo articulo) {
        apiRest.guardarArticulo(articulo).enqueue(new Callback<Articulo>() {
            @Override
            public void onResponse(Call<Articulo> call, Response<Articulo> response) {
                Toast.makeText(AppContexto.getContexto(), "Artículo añadido", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Articulo> call, Throwable t) {
                Toast.makeText(AppContexto.getContexto(), "error al añadir artículo", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
