/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.aiep.ena.dao;

import cl.aiep.ena.dao.utils.ConexionSql;
import cl.aiep.ena.models.Departamento;
import cl.aiep.ena.models.Estado;
import cl.aiep.ena.models.Requerimiento;
import cl.aiep.ena.models.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author exvicad
 */
public class RequerimientoDAO extends ConexionSql {
    private final static int ESTADO_CERRADO = 0;
    private final static int ESTADO_ABIERTO = 1;
    
    public int registrarRequerimiento(Requerimiento req) throws ClassNotFoundException, SQLException{
        String sentencia = "insert into requerimiento values (?,?,?,?,?,?)";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setInt(1, 0);
        ps.setInt(2, req.getUsuario().getId());
        ps.setInt(3, req.getDepto().getId());
        ps.setInt(4, req.getAsignatario().getId());
        ps.setInt(5, ESTADO_ABIERTO);
        ps.setString(6, req.getDetalle());
        int r = ps.executeUpdate();
        return r;
        }catch(Exception e){
            //return -1;
            throw e;
        }finally{
            desconectar();
        }
    }
    
    public int cerrarRequerimiento(Requerimiento req) throws ClassNotFoundException, SQLException{
        String sentencia = "update requerimiento set estado=? where id=?";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setInt(1, ESTADO_CERRADO);
        ps.setInt(2, req.getId());
        int r = ps.executeUpdate();
        return r;
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public ArrayList<Requerimiento> obtenerRequerimientos() throws ClassNotFoundException, SQLException{
        String sentencia = "select * from requerimiento";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ResultSet rs = ps.executeQuery();
        ArrayList<Requerimiento> lista = new ArrayList();
        while(rs.next()){
            Departamento depto = new Departamento(rs.getInt("depto"));
            lista.add(new Requerimiento(rs.getInt("id"), usuario, depto, asignatario, Estado.CERRADO, sentencia));
        }
        return lista;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
    
    public Usuario obtenerUsuario(int id) throws ClassNotFoundException, SQLException{
        String sentencia = "select * from usuario where id = ?";
        try{
        conectar();
        PreparedStatement ps = obtenerPS(sentencia);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Usuario u = null;
        if(rs.next()){
            Departamento depto = new Departamento(rs.getInt("depto"));
            u = new Usuario(rs.getInt("id"), rs.getString("usuario"), rs.getString("password"),
                    rs.getString("nombre"), rs.getString("apellido"), depto);
        }
        return u;
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }
    
    public Usuario validarUsuario(String usr) throws ClassNotFoundException, SQLException{
        String sentencia = "select * from usuarios where usuario = ?";
        try{
        conectar();
        PreparedStatement ps = obtenerPS(sentencia);
        ps.setString(1, usr);
        ResultSet rs = ps.executeQuery();
        Usuario u = null;
        if(rs.next()){
            Departamento depto = new Departamento(rs.getInt("depto"));
            u = new Usuario(rs.getInt("id"), rs.getString("usuario"), rs.getString("password"),
                   rs.getString("nombre"), rs.getString("apellido"), depto);
        }
        return u;
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }
}
