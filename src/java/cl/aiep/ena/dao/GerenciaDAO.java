/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.aiep.ena.dao;

import cl.aiep.ena.dao.utils.ConexionSql;
import cl.aiep.ena.models.Departamento;
import cl.aiep.ena.models.Gerencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author exvicad
 */
public class GerenciaDAO extends ConexionSql {
    
    public int registrarGerencia(Departamento g) throws SQLException, Exception{
        String sentencia = "insert into gerencia values (?,?)";
        try {
            conectar();
            PreparedStatement ps= obtenerPS(sentencia);
            ps.setInt(1, 0);
            ps.setString(1, g.getNombre());
            int r = ps.executeUpdate();
            return r;
        } catch (Exception e) {
            throw e;
        }finally{
            desconectar();
        }
    }
    
    public Gerencia obtenerGerencia(int id) throws SQLException{
        String sentencia = "select * from gerencia where id=?";
        Gerencia g = null;
        try {
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                g = new Gerencia(rs.getInt("id"), rs.getString("nombre"));
            }
            return g;
        } catch (Exception e) {
            return g;
        }finally{
            desconectar();
        }
    }
}
