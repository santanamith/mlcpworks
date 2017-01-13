/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transacciones;

import AccesoBasedeDatos.ConexionDb;
import ClasesGenericas.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PSantana
 */
public class MantenimientoCliente {
    ConexionDb cn;
    public MantenimientoCliente(){
        cn=new ConexionDb();
    }
    public void insertEmpleado(Cliente cliente) {
        try {   
            PreparedStatement ps = cn.ConexionDB().prepareStatement(
            "insert into cliente values(?,?,?,?)");

            ps.setInt(1, cliente.getId_cliente());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getDocumento());
            
            int ex=ps.executeUpdate();
            ps.close();
            if(ex>0)
                JOptionPane.showMessageDialog(null, "Registro añadido");
        } catch (SQLException ex) {
            System.out.println("Error al registrar "+ex.getMessage());
        }
    }
    public void buscarXID(String id,DefaultTableModel tabla) {
        int f=0;
        try {
            ResultSet rs=cn.EjecutarRS("select * from cliente where id_cliente like '"+id+"%'");
            tabla.setRowCount(0);
            while (rs.next()){
                f=tabla.getRowCount();
                tabla.setRowCount(f+1);
                tabla.setValueAt(rs.getInt("id_cliente"), f, 0);
                tabla.setValueAt(rs.getString("apellido"), f, 1);
                tabla.setValueAt(rs.getString("nombre"), f, 2);
                tabla.setValueAt(rs.getString("documento"), f, 3);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al Estableces datos de la tabla cliente "+ex.getMessage());
        }
    }
    public void buscarXDoc(String doc,DefaultTableModel tabla) {
        int f=0;
        try {
            ResultSet rs=cn.EjecutarRS("select * from cliente where documento like '"+doc+"%'");
            tabla.setRowCount(0);
            while (rs.next()){
                f=tabla.getRowCount();
                tabla.setRowCount(f+1);
                tabla.setValueAt(rs.getInt("id_cliente"), f, 0);
                tabla.setValueAt(rs.getString("apellido"), f, 1);
                tabla.setValueAt(rs.getString("nombre"), f, 2);
                tabla.setValueAt(rs.getString("documento"), f, 3);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al Estableces datos de la tabla cliente "+ex.getMessage());
        }
    }
}
