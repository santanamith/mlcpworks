/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBasedeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                try {
                        Statement  st = cn.createStatement() ;
                        rs  = st.executeQuery ( sql ) ;
                } catch ( SQLException  e ) {
                       JOptionPane.showMessageDialog( null, 
                            "Error al ejecutarRS\n" +   e.getMessage() );
                } // try-catch
                return rs ;    
        } 
}
