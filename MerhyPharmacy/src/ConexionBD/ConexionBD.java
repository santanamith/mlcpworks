/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Marisol
 */
public class ConexionBD {
    private Connection con;
    private Statement  sentSQL;
    private ResultSet rst;


    public ConexionBD() {
        //cargar el controlador jdbc
        String controlador="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(controlador).newInstance();
            conectar();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error "+ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("Error "+ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("Error "+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error "+ex.getMessage());
        }
         //conectar con la fuente de datos
    }

    public void conectar() throws SQLException{
        //datos necesarios para la conexion
    String URL_bd="jdbc:sqlserver://.;databaseName=PHARMACY_MERHY";
    String usuario="sa";
    String contraseña="123";
    //conexion con la bd
    con=DriverManager.getConnection(URL_bd,usuario,contraseña);
    // se crea una Statement para asi poder usar sentencias sql
    sentSQL=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }   
  
    // metodo para ejecutar sentencia sql
     public String ejecutar(String sql) throws SQLException
		  {
                      //executeUpdate nos sirve para hacer UPDATE, INSERT y ese tipo de sentencias que modifican la base de datos
                      // no se necesita devolver algo
                       sentSQL.executeUpdate(sql);
                       
		  return "";
		  }
     
     //metodo para ejecutar consultas de sentencias sql en la base de datos
     public ResultSet Consulta(String sql) throws SQLException{
         
         //executeQuery nos sirve solamente para hacer consultas de la base de datos, solo acepta sentencias como SELECT
         // se necesita forzosamente devolver algo, guardar en una variable el resultado de la consulta
        rst=sentSQL.executeQuery(sql);
        
       return rst;
    }
     
    public void setTipo(JComboBox cmbTipo){
        try {
            cmbTipo.removeAllItems();
            ResultSet rs=Consulta("select * from tipo");
            while(rs.next()){                
                cmbTipo.addItem(rs.getInt("idtipo")+" "+rs.getString("nombres"));
            }
        } catch (SQLException ex) {
            System.out.println("Error al llenar combobox "+ex.getMessage());
        }
    } 
}
