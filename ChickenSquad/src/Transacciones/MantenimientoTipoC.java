/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transacciones;

import AccesoBasedeDatos.ConexionDb;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author PSantana
 */
public class MantenimientoTipoC {
    ConexionDb cn=new ConexionDb();
    public MantenimientoTipoC(){
        cn.ConexionDB();
    }
    public void setTipoC(JComboBox cmb) {
        String sql="Select tipo_comprobante from tipocomprobante ";
        cmb.removeAllItems();
        try {
            ResultSet rs= cn.EjecutarRS(sql);
            while (rs.next()){
                cmb.addItem(rs.getString("tipo_comprobante") );     
            }
        }catch(SQLException ex){
             System.out.println("Error al obtener tipocomprobante");   
        }
    }
    
    public void setEstado(JComboBox cmb) {
        String sql="Select tipo_estado from estado ";
        cmb.removeAllItems();
        try {
            ResultSet rs= cn.EjecutarRS(sql);
            while (rs.next()){
                cmb.addItem(rs.getString("tipo_estado") );     
            }
        }catch(SQLException ex){
             System.out.println("Error al obtener tipoestado");   
        }
    }
    public void setIGV(JTextField t) {
        String sql="Select monto from igv where id_impuesto=1";
        t.setText("");
        try {
            ResultSet rs= cn.EjecutarRS(sql);
            if(rs.next()){
                t.setText(rs.getString("monto") ); 
            }
            rs.close();
        }catch(SQLException ex){
             System.out.println("Error al obtener igv");   
        }
    }
   
}
