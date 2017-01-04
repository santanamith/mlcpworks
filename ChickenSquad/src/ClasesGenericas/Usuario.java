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
    private String clave ;
    private String cargo ;

    public Usuario() {
    }

    public Usuario(String usuario, String clave, String cargo) {
        this.usuario = usuario;
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
    
}
