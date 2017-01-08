package Transacciones;

import AccesoBasedeDatos.ConexionDb;
import AccesoBasedeDatos.ConexionDb2;
import ClasesGenericas.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

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

    public void setTable(DefaultTableModel tabla) {
        int f=0;
        ResultSet rs=cn.EjecutarRS("select * from producto");
        tabla.setRowCount(0);
        try {
            while (rs.next()){
                f=tabla.getRowCount();
                tabla.setRowCount(f+1);
                tabla.setValueAt(rs.getString("idproducto"), f, 0);
                tabla.setValueAt(rs.getString("nombreproducto"), f, 1);
                tabla.setValueAt(rs.getString("descripcionproducto"), f, 2);
                tabla.setValueAt(rs.getDouble("precio"), f, 3);
                tabla.setValueAt(rs.getInt("stock"), f, 4);
            }
        } catch (SQLException ex) {
            System.out.println("Error al Estableces datos de la tabla Productos "+ex.getMessage());
        }
    }
}
