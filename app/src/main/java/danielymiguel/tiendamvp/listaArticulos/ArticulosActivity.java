package danielymiguel.tiendamvp.listaArticulos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import danielymiguel.tiendamvp.AppContexto;
import danielymiguel.tiendamvp.R;
import danielymiguel.tiendamvp.modelos.Articulo;

public class ArticulosActivity extends AppCompatActivity implements ArticulosContract.View{

    public static final String POSICION = "POSICION";

    @BindView(R.id.lv_articulos)
    ListView listViewArticulos;

    private ArticulosContract.Presenter articulosPresenter;
    private ArticulosAdapter articulosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articulos_main);
        ButterKnife.bind(this);

        Toast.makeText(AppContexto.getContexto(), "cargando...", Toast.LENGTH_SHORT).show();

        articulosPresenter = new ArticulosPresenter(this);

        //Comprobar que tiene conexion a internet
        if (!articulosPresenter.compruebaConexion(AppContexto.getContexto())) {
            Toast.makeText(AppContexto.getContexto(), "Se necesita conexión a internet", Toast.LENGTH_SHORT).show();
        }

        setLayout();

        articulosPresenter.cargaDatos();
    }

    /**
     * Configuración de la vista
     */
    private void setLayout() {
        //Crear adaptador
        articulosAdapter = new ArticulosAdapter(AppContexto.getContexto(), new ArrayList<Articulo>());
        listViewArticulos.setAdapter(articulosAdapter);

        //Evento click en item de la lista
        listViewArticulos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Se lanza la Activity de detalles de la noticia
//                Intent intent = new Intent(AppContexto.getContexto(), ArticuloDetalleActivity.class);
//                intent.putExtra(POSICION, i);
//                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void mostrarArticulos(List<Articulo> articulos){
        articulosAdapter.updateArticulos(articulos);
        Log.v("Errores::", "ArticulosActivity::mostrarArticulos::Se ha actualizado el adaptador.");
    }

    @Override
    public void mostrarError() {
        Toast.makeText(AppContexto.getContexto(), "Error al cargar los Artículos", Toast.LENGTH_SHORT).show();
    }

}
