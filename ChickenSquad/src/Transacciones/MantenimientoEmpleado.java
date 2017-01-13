/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transacciones;

import AccesoBasedeDatos.ConexionDb;
import ClasesGenericas.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PSantana
 */
public class MantenimientoEmpleado {
    ConexionDb cn;
    public MantenimientoEmpleado(){
        cn=new ConexionDb();
    }
    public void insertEmpleado(Empleado empleado) {
        try {   
            PreparedStatement ps = cn.ConexionDB().prepareStatement(
            "insert into empleado values(?,?,?,?,?,?,?,?,?)");

            ps.setInt(1, empleado.getId_empleado());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApe_pat());
            ps.setString(4, empleado.getApe_mat());
            ps.setString(5, empleado.getDni());
            ps.setString(6, empleado.getId_distrito());
            ps.setString(7, empleado.getDireccion());
            ps.setString(8, empleado.getUsuario());
            ps.setString(9, empleado.getFechaing());
            int ex=ps.executeUpdate();
            ps.close();
            if(ex>0)
                JOptionPane.showMessageDialog(null, "Registro añadido");
        } catch (SQLException ex) {
            System.out.println("Error al registrar "+ex.getMessage());
        }
    }
    
    public void updateEmpleado(Empleado empleado) {
        try {   
            PreparedStatement ps = cn.ConexionDB().prepareStatement(
            "UPDATE EMPLEADO SET nombre=?,ape_pat=?,ape_mat=?,dni=?,id_distrito=?,direccion=?,fechaing=? "
                    + "WHERE id_empleado=?;");
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApe_pat());
            ps.setString(3, empleado.getApe_mat());
            ps.setString(4, empleado.getDni());
            ps.setString(5, empleado.getId_distrito());
            ps.setString(6, empleado.getDireccion());
            ps.setString(7, empleado.getFechaing());
            ps.setInt(8, empleado.getId_empleado());
            int ex=ps.executeUpdate();
            ps.close();
            if(ex>0)
                JOptionPane.showMessageDialog(null, "Registro actualizado");
        } catch (SQLException ex) {
            System.out.println("Error al actualizar "+ex.getMessage());
        }
    }
    
    public void buscarXdni(String dni,JTextField t1,JTextField t2,JTextField t3,JTextField t4,
            JTextField t5,JTextField t7,JTextField t8 ) {
        int f=0;
        try {
            ResultSet rs=cn.EjecutarRS("select * from empleado where dni  ='"+dni+"'");
            
            if (rs.next()){
                t1.setText(""+rs.getInt("id_empleado"));
                t2.setText(rs.getString("nombre"));
                t3.setText(rs.getString("ape_pat"));
                t4.setText(rs.getString("ape_mat"));
                t5.setText(rs.getString("dni"));
                
                t7.setText(rs.getString("direccion"));
                t8.setText(""+rs.getDate("fechaing"));
            }
        } catch (SQLException ex) {
            System.out.println("Error al Estableces datos de la tabla empleado "+ex.getMessage());
        }
    }
    
    public void setTable(DefaultTableModel tabla) {
        int f=0;
        ResultSet rs=cn.EjecutarRS("select * from empleado");
        tabla.setRowCount(0);
        try {
            while (rs.next()){
                f=tabla.getRowCount();
                tabla.setRowCount(f+1);
                tabla.setValueAt(rs.getInt("id_empleado"), f, 0);
                tabla.setValueAt(rs.getString("nombre"), f, 1);
                tabla.setValueAt(rs.getString("ape_pat"), f, 2);
                tabla.setValueAt(rs.getString("ape_mat"), f, 3);
                tabla.setValueAt(rs.getString("dni"), f, 4);
                tabla.setValueAt(rs.getString("id_distrito"), f, 5);
                tabla.setValueAt(rs.getString("direccion"), f, 6);
                tabla.setValueAt(rs.getString("usuario"), f, 7);
                tabla.setValueAt(rs.getDate("fechaing"), f, 8);
            }
        } catch (SQLException ex) {
            System.out.println("Error al Estableces datos de la tabla empleado "+ex.getMessage());
        }
    }
}
