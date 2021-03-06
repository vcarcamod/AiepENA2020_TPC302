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
public class DepartamentoDAO extends ConexionSql {
    
    public int registrarDepartamento(Departamento dpto) throws SQLException, Exception{
        String sentencia = "insert into departamento values (?,?,?)";
        try {
            conectar();
            PreparedStatement ps= obtenerPS(sentencia);
            ps.setInt(1, 0);
            ps.setString(1, dpto.getNombre());
            ps.setInt(2, dpto.getGerencia().getId());
            int r = ps.executeUpdate();
            return r;
        } catch (Exception e) {
            throw e;
        }finally{
            desconectar();
        }
    }
    
    public Departamento obtenerDepartamento(int id) throws SQLException{
        String sentencia = "select * from departamento where id=?";
        Departamento depto = null;
        try {
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                GerenciaDAO gd = new GerenciaDAO();
                Gerencia gerencia = gd.obtenerGerencia(rs.getInt("id_gerencia"));
                depto = new Departamento(rs.getInt("id"), rs.getString("nombre"), gerencia);
            }
            return depto;
        } catch (Exception e) {
            return depto;
        }finally{
            desconectar();
        }
    }
}
