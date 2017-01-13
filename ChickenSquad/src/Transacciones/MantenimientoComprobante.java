/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transacciones;

import AccesoBasedeDatos.ConexionDb;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author PSantana
 */
public class MantenimientoComprobante {
    ConexionDb cn;
    public MantenimientoComprobante() {
        cn=new ConexionDb();
    }
     public void insertComprobante(String usuario, String doccli, String tc, double pagototal, double subt,
             String te,int n,String id_prod,String cant,String precio) {
        int r = 0;
        try {
            
            CallableStatement cs=cn.ConexionDB().prepareCall("{CALL SP_INS_FACTURA (?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, usuario);
            cs.setString(2, doccli);
            cs.setString(3, tc);
            cs.setDouble(4, pagototal);
            cs.setDouble(5, subt);
            cs.setString(6, te);
            cs.setInt(7, n);
            cs.setString(8, id_prod);
            cs.setString(9, cant);
            cs.setString(10, precio);
            int i=cs.executeUpdate();
            if(i>0)
                JOptionPane.showMessageDialog(null, "Registro completo");
        } catch (Exception ex) {
            System.out.println("Error al insertar Comprobante "+ex.getMessage());
        }
    }
}
