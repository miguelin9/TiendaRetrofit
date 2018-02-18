package danielymiguel.tiendamvp.listaArticulos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import danielymiguel.tiendamvp.AppContexto;
import danielymiguel.tiendamvp.R;
import danielymiguel.tiendamvp.modelos.Articulo;


public class ArticulosAdapter extends BaseAdapter {

    private Context context;
    private List<Articulo> articulos;

    public ArticulosAdapter(Context context, List<Articulo> articulos) {
        this.context = context;
        this.articulos = articulos;
    }

    public void updateArticulos(List<Articulo> nuevaLista){
        this.articulos = nuevaLista;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return articulos.size();
    }

    @Override
    public Object getItem(int i) {
        return articulos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.articulos_lista_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Articulo articulo = (Articulo) getItem(i);


        viewHolder.nombre.setText(articulo.getNombre());
        viewHolder.stock.setText(String.valueOf(articulo.getStock()));
        viewHolder.codigo.setText(String.valueOf(articulo.getCodigo()));
        Glide.with(AppContexto.getContexto()).load(articulo.getFoto()).into(viewHolder.imagen);

        return view;
    }

    public static class ViewHolder {
        @BindView(R.id.tv_nombre)
        TextView nombre;
        @BindView(R.id.tv_stock)
        TextView stock;
        @BindView(R.id.tv_codigo)
        TextView codigo;
        @BindView(R.id.imagen)
        ImageView imagen;

        public ViewHolder(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
