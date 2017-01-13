/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGenericas;

/**
 *
 * @author PSantana
 */
public class Usuario {
    private String usuario ;
    private int id_empleado ;
    private String clave ;
    private String cargo ;

    public Usuario() {
    }

    public Usuario(String usuario,int id_empleado, String clave, String cargo) {
        this.usuario = usuario;
        this.id_empleado = id_empleado;
        this.clave = clave;
        this.cargo = cargo;
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
    
}
