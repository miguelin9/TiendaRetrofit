package danielymiguel.tiendamvp.modelos.api;

import java.util.List;
import danielymiguel.tiendamvp.modelos.Articulo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiRest {

    @POST("articulos")
    Call<Articulo> guardarArticulo(@Body Articulo articulo);

    @GET("articulos")
    Call<List<Articulo>> obtenerArticulos();

    @GET("articulos/{codigo}")
    Call<List<Articulo>> obtenerArticulo(@Path("codigo") int codigo);

    @DELETE("articulos/{codigo}")
    Call<Articulo> borrarArticulo(@Path("codigo") int codigo);

    @PUT("articulos/{codigo}")
    Call<Articulo> actualizarArticulo(@Path("codigo") int codigo);
}


