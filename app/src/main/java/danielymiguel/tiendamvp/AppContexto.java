package danielymiguel.tiendamvp;

import android.app.Application;
import android.content.Context;

/**
 * Clase para desaclopar en volley
 * Le pasamos este contexto en vez del de la activity
 * añadir en el manifest en application: android:name=".AppContext"
 */

public class AppContexto extends Application {

    private static Context contexto;

    @Override
    public void onCreate() {
        super.onCreate();
        contexto = getApplicationContext();
    }

    public static Context getContexto(){
        return contexto;
    }

}
