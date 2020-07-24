/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.aiep.ena.mb;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author exvicad
 */
@Named(value = "usuarioMB")
@SessionScoped
public class UsuarioMB implements Serializable {
    
    private String usuario;
    private String password;

    /**
     * Creates a new instance of UsuarioMB
     */
    public UsuarioMB() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void login(){
        
    }
}
