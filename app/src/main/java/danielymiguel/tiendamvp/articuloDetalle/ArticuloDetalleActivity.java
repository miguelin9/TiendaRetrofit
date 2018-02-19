package danielymiguel.tiendamvp.articuloDetalle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import danielymiguel.tiendamvp.AppContexto;
import danielymiguel.tiendamvp.R;
import danielymiguel.tiendamvp.actualizarArticulo.ArticuloPUTActivity;
import danielymiguel.tiendamvp.listaArticulos.ArticulosActivity;
import danielymiguel.tiendamvp.modelos.Articulo;

public class ArticuloDetalleActivity extends AppCompatActivity implements ArticuloDetalleContract.View, View.OnClickListener {

    private static final String ARTICULO = "ARTICULO";
    private ArticuloDetalleContract.Presenter presenter;
    private int codigoArticulo;
    private Articulo aux;

    @BindView(R.id.detalle_categoria)
    TextView categoria;
    @BindView(R.id.detalle_codigo)
    TextView codigo;
    @BindView(R.id.detalle_descripcion)
    TextView descripcion;
    @BindView(R.id.detalle_nombre)
    TextView nombre;
    @BindView(R.id.detalle_stock)
    TextView stock;
    @BindView(R.id.detalle_imagen)
    ImageView imagen;
    @BindView(R.id.detalle_precio)
    TextView precio;
    @BindView(R.id.btn_actualizar)
    Button actualizar;
    @BindView(R.id.btn_borrar)
    Button borrar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articulo_detalle_activity);
        ButterKnife.bind(this);

        Log.e("Errores", "Principio del onCreate en detalle");
        codigoArticulo = getIntent().getExtras().getInt("CODIGO");
        Log.e("Errores", "obtenido código artículo: " + codigoArticulo);
        presenter = new ArticuloDetallePresenter(this);
        presenter.cargaArticulo(codigoArticulo);

        actualizar.setOnClickListener(this);
        borrar.setOnClickListener(this);
        Log.e("Errores", "Fin del onCreate en detalle");
    }

    @Override
    public void mostrarArticulo(Articulo articulo) {
        if (articulo != null) {
            aux = articulo;
            categoria.append(articulo.getCategoria());
            codigo.append(String.valueOf(articulo.getCodigo()));
            descripcion.setText(articulo.getDescripcion());
            nombre.setText(articulo.getNombre());
            stock.append(String.valueOf(articulo.getStock()));
            precio.append(String.valueOf(articulo.getPrecio()) + " €");
            Glide.with(AppContexto.getContexto()).load(articulo.getFoto()).into(imagen);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_actualizar:
                Intent intent = new Intent(AppContexto.getContexto(),ArticuloPUTActivity.class);
                intent.putExtra("ARTICULO", aux);
//                Log.e("Errores","Código artículo: " + id);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_borrar:
                AlertDialog.Builder alerta = new AlertDialog.Builder(this); // Necesita el contexto de la activity no vale el de AppContexto
                alerta.setTitle("Confirmar borrado.")
                    .setMessage("¿Está seguro de borrar el artículo?")
                    .setCancelable(true)
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            presenter.borrarArticulo(codigoArticulo);
                            startActivity(new Intent(AppContexto.getContexto(), ArticulosActivity.class));
                            finish();
                        }
                    })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AppContexto.getContexto(), "Borrado cancelado.", Toast.LENGTH_SHORT).show();
                    }
                });
                alerta.show();
                break;
        }
    }
}
