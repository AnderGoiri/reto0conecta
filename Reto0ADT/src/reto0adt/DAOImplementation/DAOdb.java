/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0adt.DAOImplementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Dificultad;
import model.Enunciado;
import reto0adt.DAO.DAO;
import reto0adt.exceptions.ServerException;

/**
 *
 * @author 2dam
 */
public class DAOdb implements DAO{

    protected Connection con;
    protected PreparedStatement stmt;
    protected DBConnection conController = new DBConnection();
        
    @Override
    public void addUnidadDidactica() {
    
    }
    @Override
    public void addEnunciado(Enunciado enunciado) throws ServerException {
    
        ResultSet rs = null;
        try {
            con = conController.openConnection();
        } catch (ServerException ex) {
            Logger.getLogger(DAOdb.class.getName()).log(Level.SEVERE, null, ex);
        }

		try {
			CallableStatement cst = con.prepareCall("INSERT INTO `enunciado` (`descripcion`, `nivel`, `disponible`, `ruta`) VALUES (?,?,?,?)");
			
			cst.setInt(1,enunciado.getId());
			cst.setString(2,enunciado.getDescripcion());
			cst.setString(3,enunciado.getNivel().toString());
                        int disponible = enunciado.isDisponible() ? 1: 0;
                        cst.setInt(4,disponible);
                        cst.setString(5, enunciado.getRuta());
			cst.execute();
			
			
		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}
		
		conController.closeConnection(stmt, con);
		
        
    }

    @Override
    public void checkUnidadDidactica() {
    
    }

    @Override
    public void showEnunciadoByUnidadDidactica() {
    
    }
    
    
    @Override
    public void addConvocatoria() { }
    @Override
    public void checkConvocatoria() {}
    @Override
    public void showConvocatoria() {}
    
   
    
}
