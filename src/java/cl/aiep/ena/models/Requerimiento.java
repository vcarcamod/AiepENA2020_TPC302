/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.aiep.ena.models;

/**
 *
 * @author exvicad
 */
public class Requerimiento {
    int id;
    Usuario usuario;
    Departamento depto;
    Encargado asignatario;
    Estado estado;
    String detalle;

    public Requerimiento() {
    }

    public Requerimiento(int id, Usuario usuario, Departamento depto, Encargado asignatario, Estado estado, String detalle) {
        this.id = id;
        this.usuario = usuario;
        this.depto = depto;
        this.asignatario = asignatario;
        this.estado = estado;
        this.detalle = detalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Departamento getDepto() {
        return depto;
    }

    public void setDepto(Departamento depto) {
        this.depto = depto;
    }

    public Encargado getAsignatario() {
        return asignatario;
    }

    public void setAsignatario(Encargado asignatario) {
        this.asignatario = asignatario;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
}
