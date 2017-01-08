/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBasedeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author PSantana
 */
public class ConexionDb {
    Connection  cn=null;
    public Connection ConexionDB(){      
        try {
            String drv="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String cnx="jdbc:sqlserver://MCINTHEHOUSE\\MCINTHEHOUSE;databasename=CHICKENSQUAD;" +
                                                 "user=sa;password=123456" ;
            Class.forName( drv ) ;
            cn  = DriverManager.getConnection( cnx  ) ;
        } catch (ClassNotFoundException ex) {
            System.out.println("No se encuentra la "+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error sqlexection "+ ex.getMessage());
        }
                return  cn ;
    }
    public  ResultSet  EjecutarRS( String sql ) {
                ResultSet rs = null ;     
                Statement  st ;
        try {
            ConexionDB();
            st = cn.createStatement();
            rs  = st.executeQuery ( sql ) ;
        } catch (SQLException ex) {
            System.out.println("Error en el ejecutar rs");
        }finally{
                    try {
                        ConexionDB().close();
                    } catch (SQLException ex) {
                        System.out.println("Error al cerrar");
                    }
        } 
        
                return rs ;    
        } 
    public void editIGV(int id,int monto) {
        try {   
            PreparedStatement pst = cn.prepareStatement("UPDATE IGV SET monto=?"+" WHERE id_impuesto=?");
            pst.setInt(1, monto);
            pst.setInt(2, id);
            int ex=pst.executeUpdate();
            if(ex>0)
                JOptionPane.showMessageDialog(null, "Editado Correctamente");
        } catch (SQLException ex) {
            System.out.println("Error al editar igv");
        }
    }
    
    public void getDistrito(JComboBox cmb) {
              
        cmb.removeAllItems();
        cmb.addItem("(Distrito)");
        try {
            ResultSet rs=EjecutarRS("select * from distrito");
            while (rs.next()){
                cmb.addItem(rs.getString("distrito")+" "+rs.getString("ID_DISTRITO"));     
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los distritos   "+e.getMessage());
        } 
    }
}
