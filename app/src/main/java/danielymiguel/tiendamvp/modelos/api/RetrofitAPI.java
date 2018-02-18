package danielymiguel.tiendamvp.modelos.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by miguel on 18/02/18.
 */

public class RetrofitAPI {

    public static final String url = "http://52.47.123.57:5000";
    private static Retrofit retrofit = null;

    // Devuelve el cliente con la ruta del server
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    // Devuelve el cliente con las rutas del fichero ApiRest
    public static ApiRest getAPIRest() {
        return getClient().create(ApiRest.class);
    }

}
