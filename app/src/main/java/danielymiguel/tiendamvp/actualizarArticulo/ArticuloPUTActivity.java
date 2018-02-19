package danielymiguel.tiendamvp.actualizarArticulo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import danielymiguel.tiendamvp.AppContexto;
import danielymiguel.tiendamvp.R;
import danielymiguel.tiendamvp.listaArticulos.ArticulosActivity;
import danielymiguel.tiendamvp.modelos.Articulo;

public class ArticuloPUTActivity extends AppCompatActivity implements View.OnClickListener, ArticuloPUTContract.View {

    private ArticuloPUTContract.Presenter presenter;
    private Articulo articulo;

    private String nombre;
    private String categoria;
    private String stock;
    private String precio;
    private String imagen;
    private String descripcion;

    @BindView(R.id.sCategoria)
    Spinner sCategoriaSpinner;
    @BindView(R.id.cod)
    TextInputLayout cod;
    @BindView(R.id.tv_titulo)
    TextView tvTitulo;
    @BindView(R.id.codigo)
    EditText tvCodigo;
    @BindView(R.id.nombre)
    EditText tvNombre;
    @BindView(R.id.categoria)
    EditText tvCategoria;
    @BindView(R.id.stock)
    EditText tvStock;
    @BindView(R.id.precio)
    EditText tvPrecio;
    @BindView(R.id.descipcion)
    EditText tvDescripcion;
    @BindView(R.id.imagen)
    EditText tvImagen;
    @BindView(R.id.fbutton)
    Button btnActualizar;

    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_anadir);
        ButterKnife.bind(this);

        presenter = new ArticuloPUTPresenter(this);

        articulo = (Articulo) getIntent().getSerializableExtra("ARTICULO");
        Log.e("Errores", "artículo: " + articulo.toString());

        // Se reutiliza el xml de formulario
        tvTitulo.setVisibility(View.GONE);
        tvCodigo.setVisibility(View.GONE);
        cod.setVisibility(View.GONE);
        tvCategoria.setVisibility(View.GONE);

        btnActualizar.setText("Actualizar");
        btnActualizar.setOnClickListener(this);

        adapter = ArrayAdapter.createFromResource(AppContexto.getContexto(),
                R.array.categorias,android.R.layout.simple_dropdown_item_1line);
        sCategoriaSpinner.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fbutton:
                comprobarCampos();
                presenter.actualizarArticulo(new Articulo(articulo.getCodigo(), nombre, categoria, Integer.parseInt(stock), Float.parseFloat(precio), imagen, descripcion));
                startActivity(new Intent(AppContexto.getContexto(), ArticulosActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void comprobarCampos() {
        if (tvNombre.getText().toString().isEmpty()) {
            nombre = articulo.getNombre();
        } else {
            nombre = tvNombre.getText().toString();
        }

        if (tvCategoria.getText().toString().isEmpty()) {
            categoria = sCategoriaSpinner.getSelectedItem().toString();
        } else {
            categoria = sCategoriaSpinner.getSelectedItem().toString();
        }

        if (tvStock.getText().toString().isEmpty()) {
            stock = String.valueOf(articulo.getStock());
        } else {
            stock = tvStock.getText().toString();
        }

        if (tvPrecio.getText().toString().isEmpty()) {
            precio = String.valueOf(articulo.getPrecio());
        } else {
            precio = tvPrecio.getText().toString();
        }

        if (tvImagen.getText().toString().isEmpty()) {
            imagen = articulo.getFoto();
        } else {
            imagen = tvImagen.getText().toString();
        }

        if (tvDescripcion.getText().toString().isEmpty()) {
            descripcion = articulo.getDescripcion();
        } else {
            descripcion = tvDescripcion.getText().toString();
        }
    }

}
