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
public class Empleado {
    private int id_empleado;
    private String nombre;
    private String ape_pat;
    private String ape_mat;
    private String dni;
    private String id_distrito;
    private String direccion;
    private String fechaing;
    private String usuario;

    public Empleado() {
    }

    public Empleado(int id_empleado, String nombre, String ape_pat, String ape_mat, String dni, String id_distrito, String direccion, String fechaing) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.ape_pat = ape_pat;
        this.ape_mat = ape_mat;
        this.dni = dni;
        this.id_distrito = id_distrito;
        this.direccion = direccion;
        this.fechaing = fechaing;
    }

    public Empleado(int id_empleado, String nombre, String ape_pat, String ape_mat, String dni, String id_distrito, String direccion, String fechaing, String usuario) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.ape_pat = ape_pat;
        this.ape_mat = ape_mat;
        this.dni = dni;
        this.id_distrito = id_distrito;
        this.direccion = direccion;
        this.fechaing = fechaing;
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe_pat() {
        return ape_pat;
    }

    public void setApe_pat(String ape_pat) {
        this.ape_pat = ape_pat;
    }

    public String getApe_mat() {
        return ape_mat;
    }

    public void setApe_mat(String ape_mat) {
        this.ape_mat = ape_mat;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getId_distrito() {
        return id_distrito;
    }

    public void setId_distrito(String id_distrito) {
        this.id_distrito = id_distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaing() {
        return fechaing;
    }

    public void setFechaing(String fechaing) {
        this.fechaing = fechaing;
    }
    
}
