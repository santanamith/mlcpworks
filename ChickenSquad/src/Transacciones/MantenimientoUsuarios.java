/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transacciones;

import AccesoBasedeDatos.ConexionDb;
import ClasesGenericas.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PSantana
 * 
 */
public class MantenimientoUsuarios {
    ConexionDb cn;
    public MantenimientoUsuarios(){
        cn=new ConexionDb();
    }
    public void insertUser(Usuario usuario) {
        try {
            PreparedStatement pst = cn.ConexionDB().prepareStatement("insert into usuario values(?,?,?,?)");
            pst.setString(1, usuario.getUsuario());
            pst.setInt(2, usuario.getId_empleado());
            pst.setString(3, usuario.getClave());
            pst.setString(4, usuario.getCargo());
            
            int exinsert = pst.executeUpdate();
            pst.close();
            if (exinsert > 0) {
                JOptionPane.showMessageDialog(null, "Registrado correctamente");
            }
        } catch (Exception e) {
            System.out.println("error insertproduct" + e.getMessage());
        }
    }
    public void deleteUser(String usuario) {
        try {
            PreparedStatement pst = cn.ConexionDB().prepareStatement("delete from USUARIO where usuario=?");

            pst.setString(1, usuario);
            int exinsert = pst.executeUpdate();
            if (exinsert > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            }else{
                JOptionPane.showMessageDialog(null, "El usuario que escribio es incorrecto");
            }
        } catch (Exception e) {
            System.out.println("error deleteUser" + e.getMessage());
        }
        //Asi es mas o menos
    }
    public void setidEmpl(JComboBox cmb) {
        String sql="Select nombre,ape_pat,id_empleado from empleado";
        cmb.removeAllItems();
        cmb.addItem("(Usuarios)");
        try {
            ResultSet rs= cn.EjecutarRS(sql);
            while (rs.next()){
                cmb.addItem(rs.getString("nombre")+" "+rs.getString("ape_pat") + " ,"+rs.getInt("id_empleado") );     
            }
        }catch(SQLException ex){
             System.out.println("Error al obtener Usuarios");   
        }
    }
    public void setTable(DefaultTableModel tabla) {
        int f=0;
        ResultSet rs=cn.EjecutarRS("select * from usuario");
        tabla.setRowCount(0);
        try {
            while (rs.next()){
                f=tabla.getRowCount();
                tabla.setRowCount(f+1);
                tabla.setValueAt(rs.getString("usuario"), f, 0);
                tabla.setValueAt(rs.getString("id_empleado"), f, 1);
                tabla.setValueAt("*******", f, 2);
                tabla.setValueAt(rs.getString("cargo"), f, 3);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al Estableces datos de la tabla Productos "+ex.getMessage());
        }
    }
    
}
