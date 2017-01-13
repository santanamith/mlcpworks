package Transacciones;

import AccesoBasedeDatos.ConexionDb;
import AccesoBasedeDatos.ConexionDb2;
import ClasesGenericas.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
                JOptionPane.showMessageDialog(null, "Registrado correctamente");
            }
        } catch (Exception e) {
            System.out.println("error insertproduct" + e.getMessage());
        }

    }

    public void editarProduc(Producto producto) {
        try {
            PreparedStatement pst = cn.ConexionDB().prepareStatement("UpDATE  producto set nombreproducto=?,descripcionproducto=?,precio=?,stock=? "
                    + " where idproducto=?");
            
            pst.setString(1, producto.getNombreproducto());
            pst.setString(2, producto.getDescripcionproducto());
            pst.setDouble(3, producto.getPrecio());
            pst.setInt(4, producto.getStock());
            pst.setString(5, producto.getIdproducto());

            int exinsert = pst.executeUpdate();
            pst.close();
            if (exinsert > 0) {
                JOptionPane.showMessageDialog(null, "Editado correctamente");
            }
        } catch (Exception e) {
            System.out.println("error editarProduc" + e.getMessage());
        }

    }

    public void deleteproduc(String idproducto) {
        try {
            PreparedStatement pst = cn.ConexionDB().prepareStatement("delete from producto where idproducto=?");

            pst.setString(1, idproducto);
            int exinsert = pst.executeUpdate();
            if (exinsert > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            }else{
                JOptionPane.showMessageDialog(null, "El id que escribio es incorrecto");
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
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al Estableces datos de la tabla Productos "+ex.getMessage());
        }
    }
    
    public void buscarXID(String id,DefaultTableModel tabla) {
        int f=0;
        try {
            ResultSet rs=cn.EjecutarRS("select * from producto where idproducto like '"+id+"%'");
            tabla.setRowCount(0);
            while (rs.next()){
                f=tabla.getRowCount();
                tabla.setRowCount(f+1);
                tabla.setValueAt(rs.getString("idproducto"), f, 0);
                tabla.setValueAt(rs.getString("nombreproducto"), f, 1);
                tabla.setValueAt(rs.getString("descripcionproducto"), f, 2);
                tabla.setValueAt(rs.getDouble("precio"), f, 3);
                tabla.setValueAt(rs.getInt("stock"), f, 4);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al Estableces datos de la tabla Productos "+ex.getMessage());
        }
    }
    public void buscarXNombre(String name,JTextField t1,JTextField t2,JTextField t3,JTextField t4,JTextField t5) {
        int f=0;
        try {
            ResultSet rs=cn.EjecutarRS("select * from producto where nombreproducto  ='"+name+"'");
            
            if (rs.next()){
                t1.setText(rs.getString("idproducto"));
                t2.setText(rs.getString("nombreproducto"));
                t3.setText(rs.getString("descripcionproducto"));
                t4.setText(""+rs.getDouble("precio"));
                t5.setText(""+rs.getInt("stock"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al Estableces datos de la tabla Productos "+ex.getMessage());
        }
    }
    public void buscarXNombre(String name,DefaultTableModel tabla) {
        int f=0;
        try {
            ResultSet rs=cn.EjecutarRS("select * from producto where nombreproducto like '"+name+"%'");
            tabla.setRowCount(0);
            while (rs.next()){
                f=tabla.getRowCount();
                tabla.setRowCount(f+1);
                tabla.setValueAt(rs.getString("idproducto"), f, 0);
                tabla.setValueAt(rs.getString("nombreproducto"), f, 1);
                tabla.setValueAt(rs.getString("descripcionproducto"), f, 2);
                tabla.setValueAt(rs.getDouble("precio"), f, 3);
                tabla.setValueAt(rs.getInt("stock"), f, 4);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al Estableces datos de la tabla Productos "+ex.getMessage());
        }
    }
}
