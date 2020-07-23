/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.aiep.ena.dao;

import cl.aiep.ena.dao.utils.ConexionSql;
import cl.aiep.ena.models.Departamento;
import cl.aiep.ena.models.DeptoMtto;
import cl.aiep.ena.models.Encargado;
import cl.aiep.ena.models.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author exvicad
 */
public class EncargadoDAO extends ConexionSql {
    
    public int registrarUsuario(Encargado enc) throws ClassNotFoundException, SQLException{
        String sentencia = "insert into usuarios values (?,?,?,?,?,?)";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setInt(1, 0);
        ps.setString(2, enc.getUsuario());
        ps.setString(3, enc.getPassword());
        ps.setString(4, enc.getNombre());
        ps.setString(5, enc.getApellido());
        ps.setInt(6, enc.getDepto().getId());
        int r = ps.executeUpdate();
        return r;
        }catch(Exception e){
            //return -1;
            throw e;
        }finally{
            desconectar();
        }
    }
    public int modificarUsuario(Encargado u) throws ClassNotFoundException, SQLException{
        String sentencia = "update usuario set nombre=?,apellido=?,password=?,depto=? where id=?";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getApellido());
        ps.setString(3, u.getPassword());
        ps.setInt(4, u.getDepto().getId());
        ps.setInt(5, u.getId());
        int r = ps.executeUpdate();
        return r;
        }catch(Exception e){
            return -1;
        }finally{
        desconectar();
        }
    }
    public int eliminarUsuario(Usuario u) throws ClassNotFoundException, SQLException{
        String sentencia = "delete from usuario where id=?";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setInt(1, u.getId());
        int r = ps.executeUpdate();
        return r;
        }catch(Exception e){
            return -1;
        }finally{
        desconectar();
        }
    }
    public ArrayList<Encargado> obtenerEncargados() throws ClassNotFoundException, SQLException{
        String sentencia = "select * from usuario";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ResultSet rs = ps.executeQuery();
        ArrayList<Encargado> lista = new ArrayList();
        while(rs.next()){
            DepartamentoDAO dd = new DepartamentoDAO();
            Departamento depto = dd.obtenerDepartamento(rs.getInt("depto"));
            DeptoMtto dMtto = new DeptoMtto();
            lista.add(new Encargado(dMtto, rs.getInt("id"), rs.getString("usuario"),
                    rs.getString("password"),rs.getString("nombre"), rs.getString("apellido"), depto));
        }
        return lista;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
    
    public Encargado obtenerEncargado(int id) throws ClassNotFoundException, SQLException{
        String sentencia = "select * from usuario where id = ?";
        try{
        conectar();
        PreparedStatement ps = obtenerPS(sentencia);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Encargado u = null;
        if(rs.next()){
            DepartamentoDAO dd = new DepartamentoDAO();
            Departamento depto = dd.obtenerDepartamento(rs.getInt("depto"));
            DeptoMtto dMtto = new DeptoMtto();
            u = new Encargado(dMtto, rs.getInt("id"), rs.getString("usuario"),
                    rs.getString("password"),rs.getString("nombre"), rs.getString("apellido"), depto);
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
