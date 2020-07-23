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
public class Encargado extends Usuario {
    private DeptoMtto deptoMtto;

    public Encargado(DeptoMtto deptoMtto) {
        this.deptoMtto = deptoMtto;
    }

    public Encargado(DeptoMtto deptoMtto, int id, String usuario, String password, String nombre, String apellido, Departamento depto) {
        super(id, usuario, password, nombre, apellido, depto);
        this.deptoMtto = deptoMtto;
    }

    public DeptoMtto getDeptoMtto() {
        return deptoMtto;
    }

    public void setDeptoMtto(DeptoMtto deptoMtto) {
        this.deptoMtto = deptoMtto;
    }
    
    
}
