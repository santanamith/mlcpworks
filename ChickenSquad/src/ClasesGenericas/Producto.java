
package ClasesGenericas;

/**
 *
 * @author Cibert_Poet
 */
public class Producto {
   private String idproducto; 
   private String nombreproducto; 
   private String descripcionproducto; 
   private double precio; 
   private int stock;

    public Producto() {
    }

    public Producto(String idproducto, String nombreproducto, String descripcionproducto, double precio, int stock) {
        this.idproducto = idproducto;
        this.nombreproducto = nombreproducto;
        this.descripcionproducto = descripcionproducto;
        this.precio = precio;
        this.stock = stock;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getDescripcionproducto() {
        return descripcionproducto;
    }

    public void setDescripcionproducto(String descripcionproducto) {
        this.descripcionproducto = descripcionproducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
   
}
