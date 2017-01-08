package Transacciones;

import AccesoBasedeDatos.ConexionDb;
import AccesoBasedeDatos.ConexionDb2;
import ClasesGenericas.Producto;
import java.sql.PreparedStatement;

/**
 *
 * @author Cibert_Poet
 */
public class MantenimientoProductos {

    ConexionDb cn;

    public MantenimientoProductos() {
        cn = new ConexionDb();
        
    }

    //perci no te falta listar los campos qu vas utilizzar?? no el defaultablemodel no lo estoy usando asi que no sirve
    //sera p
    public void insertproduc(Producto producto) {
        try {
            PreparedStatement pst = cn.ConexionDB().prepareStatement("insert into producto values(?,?,?,?,?)");
            pst.setString(1, producto.getIdproducto());
            pst.setString(2, producto.getNombreproducto());
            pst.setString(3, producto.getDescripcionproducto());
            pst.setDouble(4, producto.getPrecio());
            pst.setInt(5, producto.getStock());

            int exinsert = pst.executeUpdate();
            pst.close();
            if (exinsert > 0) {
                System.out.println("insertado muchachon");
            }
        } catch (Exception e) {
            System.out.println("error insertproduct" + e.getMessage());
        }

    }

    public void editarProduc(Producto producto) {
        try {
            PreparedStatement pst = cn.ConexionDB().prepareStatement("UpDATE  producto set nombrepro=?,descripcionprod=?,precio=?,stock=? "
                    + "where idproducto=?");
            pst.setString(1, producto.getIdproducto());
            pst.setString(2, producto.getNombreproducto());
            pst.setString(3, producto.getDescripcionproducto());
            pst.setDouble(4, producto.getPrecio());
            pst.setInt(5, producto.getStock());

            int exinsert = pst.executeUpdate();
            pst.close();
            if (exinsert > 0) {
                System.out.println("editado muchachon");
            }

            System.out.println("");

        } catch (Exception e) {
            System.out.println("error editarProduc" + e.getMessage());
        }

    }

    public void deleteproduc(String idproducto) {
        try {
            PreparedStatement pst = cn.ConexionDB().prepareStatement("delete from productos where idproducto=?");

            pst.setString(1, idproducto);
            int exinsert = pst.executeUpdate();
            if (exinsert > 0) {
                System.out.println("Eliminado muchachon");
            }
        } catch (Exception e) {
            System.out.println("error deleteproduc" + e.getMessage());
        }
        //Asi es mas o menos
    }

    public void listarProduc(Producto producto) {
        try {
            PreparedStatement pst = cn.ConexionDB().prepareStatement("select * from productos");
            pst.setString(1, producto.getIdproducto());
            pst.setString(2, producto.getNombreproducto());
            pst.setString(3, producto.getDescripcionproducto());
            pst.setDouble(4, producto.getPrecio());
            pst.setInt(5, producto.getStock());

            int exinsert = pst.executeUpdate();
            if (exinsert > 0) {
                System.out.println("listado muchachon");
            }

            System.out.println("");

        } catch (Exception e) {
            System.out.println("error editarProduc" + e.getMessage());
        }
    }

}
