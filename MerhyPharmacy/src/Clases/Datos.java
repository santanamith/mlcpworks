/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import ConexionBD.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marisol
 */
public class Datos {
    ConexionBD cn; 
    public Datos(){
        cn=new ConexionBD();
    }
    public void buscarProduct(String sql,DefaultTableModel tabla) {
        int f=0;
        try {
            ResultSet rs=cn.Consulta(sql);
            tabla.setRowCount(0);
            while (rs.next()){
                f=tabla.getRowCount();
                tabla.setRowCount(f+1);
                tabla.setValueAt(rs.getInt("id_producto"), f, 0);
                tabla.setValueAt(rs.getString("nombre_producto"), f, 1);
                tabla.setValueAt(rs.getInt("idtipo"), f, 2);
                tabla.setValueAt(rs.getFloat("precio"), f, 3);
                tabla.setValueAt(rs.getDate("caducidad"), f, 4);
                tabla.setValueAt(rs.getInt("existencia"), f, 5);
                tabla.setValueAt(rs.getString("descripcion"), f, 6);
                tabla.setValueAt(rs.getString("especificaciones"), f, 7);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al Estableces datos de la tabla cliente "+ex.getMessage());
        }
    }
}
