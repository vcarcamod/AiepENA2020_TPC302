/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.aiep.ena.dao;

import cl.aiep.ena.dao.utils.ConexionSql;
import cl.aiep.ena.models.Departamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author exvicad
 */
public class DepartamentoDAO extends ConexionSql {
    
    public int registrarDepartamento(Departamento dpto) throws SQLException, Exception{
        String sentencia = "insert into requerimiento values (?,?,?)";
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
}
