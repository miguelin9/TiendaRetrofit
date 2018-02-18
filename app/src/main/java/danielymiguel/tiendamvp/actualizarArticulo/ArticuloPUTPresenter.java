package danielymiguel.tiendamvp.actualizarArticulo;

import danielymiguel.tiendamvp.modelos.ArticulosRepository;

public class ArticuloPUTPresenter implements ArticuloPUTContract.Presenter {

    private ArticulosRepository articulosRepository;

    public ArticuloPUTPresenter(ArticuloPUTContract.View articuloPUTView) {
        this.articulosRepository = ArticulosRepository.getInstance();
    }

    @Override
    public void actualizarArticulo(String codigo, String nombre, String categoria, String stock, String precio, String imagen, String descripcion) {
        articulosRepository.putArticulo(codigo, nombre, categoria, stock, precio, imagen, descripcion);
    }
}