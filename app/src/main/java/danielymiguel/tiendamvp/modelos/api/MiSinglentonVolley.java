package danielymiguel.tiendamvp.modelos.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Clase SinglentonVolley para tener una instancia de Volley y tener la cola de peticiones.
 */

public class MiSinglentonVolley {

        private static MiSinglentonVolley mInstance;
        private RequestQueue mRequestQueue; // esta es la cola de peticiones.
        private ImageLoader mImageLoader;
        private static Context mCtx;

        private MiSinglentonVolley(Context context) {
            mCtx = context;
            mRequestQueue = getRequestQueue();

            mImageLoader = new ImageLoader(mRequestQueue,
                    new ImageLoader.ImageCache() {
                        private final LruCache<String, Bitmap>
                                cache = new LruCache<String, Bitmap>(20);

                        @Override
                        public Bitmap getBitmap(String url) {
                            return cache.get(url);
                        }

                        @Override
                        public void putBitmap(String url, Bitmap bitmap) {
                            cache.put(url, bitmap);
                        }
                    });
        }

        public static synchronized MiSinglentonVolley getInstance(Context context) {
            if (mInstance == null) {
                mInstance = new MiSinglentonVolley(context);
            }
            return mInstance;
        }

        public RequestQueue getRequestQueue() {
            if (mRequestQueue == null) {
                // getApplicationContext() is key, it keeps you from leaking the
                // Activity or BroadcastReceiver if someone passes one in.
                mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
            }
            return this.mRequestQueue;
        }

        public ImageLoader getImageLoader() {
            return this.mImageLoader;
        }

}
