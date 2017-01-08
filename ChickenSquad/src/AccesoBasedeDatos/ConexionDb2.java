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

/**
 *
 * @author Cibert_Poet
 */
public class ConexionDb2 {
    Connection  cn=null;
    public Connection ConexionDB(){      
        try {
            String drv="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String cnx="jdbc:sqlserver://CIBERT_POET\\CIBERT_POET;databasename=CHICKENSQUAD;" +
                                                 "user=sa;password=123" ;
            Class.forName( drv ) ;
            //configura tus huevadas listo
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
            st = cn.createStatement();
            rs  = st.executeQuery ( sql ) ;
        } catch (SQLException ex) {
            System.out.println("Error en el ejecutar rs");
        } 
                return rs ;    
        } 
}
