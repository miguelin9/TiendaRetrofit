package danielymiguel.tiendamvp.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * POJO de Articulo, serializable para poder ser parcheado el json.
 */

public class Articulo implements Serializable {

    @SerializedName("codigo")
    @Expose
    private int codigo;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("categoria")
    @Expose
    private String categoria;
    @SerializedName("precio")
    @Expose
    private float precio;
    @SerializedName("foto")
    @Expose
    private String foto;
    @SerializedName("stock")
    @Expose
    private int stock;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    public Articulo() {
    }

    public Articulo(int codigo, String nombre, String categoria, int stock, float precio, String urlToImage, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;
        this.foto = urlToImage;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String urlToImage) {
        this.foto = urlToImage;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", urlFoto='" + foto + '\'' +
                ", stock=" + stock +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
