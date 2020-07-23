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
public class DeptoMtto extends Departamento {
    private AreaMtto areaMtto;

    public DeptoMtto() {
    }

    public DeptoMtto(AreaMtto areaMtto) {
        this.areaMtto = areaMtto;
    }

    public AreaMtto getAreaMtto() {
        return areaMtto;
    }

    public void setAreaMtto(AreaMtto areaMtto) {
        this.areaMtto = areaMtto;
    }
    
    
}
