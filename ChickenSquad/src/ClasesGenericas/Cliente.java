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
public class Cliente {
    private int id_cliente;
    private String apellido ;
    private String nombre;
    private String documento;

    public Cliente() {
    }

    public Cliente(int id_cliente, String apellido, String nombre, String documento) {
        this.id_cliente = id_cliente;
        this.apellido = apellido;
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
