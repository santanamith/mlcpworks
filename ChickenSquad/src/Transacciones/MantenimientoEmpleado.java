/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transacciones;

import AccesoBasedeDatos.ConexionDb;
import ClasesGenericas.Empleado;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
}
