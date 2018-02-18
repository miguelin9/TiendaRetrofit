package danielymiguel.tiendamvp.insertarArticulos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import danielymiguel.tiendamvp.AppContexto;
import danielymiguel.tiendamvp.R;
import danielymiguel.tiendamvp.listaArticulos.ArticulosActivity;
import danielymiguel.tiendamvp.modelos.Articulo;



public class ArticuloPOSTActivity extends AppCompatActivity implements View.OnClickListener, ArticuloPOSTContract.View {

    private ArticuloPOSTContract.Presenter presenter;

    @BindView(R.id.sCategoria)
    Spinner sCategoriaSpinner;
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
    Button btnInsertar;

    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_anadir);
        ButterKnife.bind(this);

        presenter = new ArticuloPOSTPresenter(this);

        btnInsertar.setOnClickListener(this);

        adapter = ArrayAdapter.createFromResource(AppContexto.getContexto(),
                R.array.categorias, android.R.layout.simple_dropdown_item_1line);
        sCategoriaSpinner.setAdapter(adapter);

        tvCategoria.setVisibility(View.GONE);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fbutton:
                if (!comprobarCampos()) {
                    insertarCategorias();
                    presenter.insertarArticulo(new Articulo(Integer.parseInt(tvCodigo.getText().toString()), tvNombre.getText().toString(),
                            tvCategoria.getText().toString(), Integer.parseInt(tvStock.getText().toString()), Float.parseFloat(tvPrecio.getText().toString()),
                            tvImagen.getText().toString(), tvDescripcion.getText().toString()));
                    startActivity(new Intent(AppContexto.getContexto(), ArticulosActivity.class));
                    finish();
                }
                break;
        }
    }

    @Override
    public boolean comprobarCampos() {
        boolean aux = false;
        if (tvCodigo.getText().toString().isEmpty() || tvNombre.getText().toString().isEmpty() || tvStock.getText().toString().isEmpty()) {
            Toast.makeText(AppContexto.getContexto(), "Falta: Código, Nombre o Stock", Toast.LENGTH_SHORT).show();
            aux = true;
        }
        return aux;
    }

    @Override
    public void insertarCategorias() {
        tvCategoria.setText(sCategoriaSpinner.getSelectedItem().toString());
    }
}
