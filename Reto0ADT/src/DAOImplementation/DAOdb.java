/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Dificultad;
import model.Enunciado;
import DAO.DAO;
import exceptions.ServerException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import model.Convocatoria;
import model.UnidadDidactica;

/**
 * Implementation class aimed for the interaction with the Data Base
 *
 * @author 2dam, Ander Goirigolzarri Iturburu
 */
public class DAOdb implements DAO{

    protected Connection con;
    protected PreparedStatement stmt;
    protected DBConnection conController = new DBConnection();
    protected ResultSet rset;
    protected CallableStatement cst;
    protected Set<UnidadDidactica> allUD;
    protected Set<Enunciado> allEnunciado;
    protected UnidadDidactica ud;
    protected Enunciado enunciado;

/**
     * Adds a new "UnidadDidactica" to the database.
     *
     * @param ud The UnidadDidactica object to be added.
     * @throws ServerException If there is an issue with the server during the
     * operation.
     * @throws SQLException If a database access error occurs or the SQL
     * execution fails.
     * @author Ander Goirigolzarri Iturburu
     */
    @Override
    public void addUnidadDidactica(UnidadDidactica ud) throws ServerException {
        try {
            con = conController.openConnection();

            stmt = con.prepareStatement("INSERT INTO `unidad` (`id`,`acronimo`, `titulo`, `evaluacion`, `descripcion`) VALUES (?,?,?,?,?)");
            stmt.setInt(1, ud.getId());
            stmt.setString(2, ud.getAcronimo());
            stmt.setString(3, ud.getTitulo());
            stmt.setString(4, ud.getEvaluacion());
            stmt.setString(5, ud.getDescripcion());

            stmt.executeUpdate();

        } catch (SQLException e) {
            // Log the exception for debugging purposes
            Logger.getLogger(DAOdb.class.getName()).log(Level.SEVERE, null, e);

            // Rethrow the SQLException as a ServerException
            throw new ServerException(e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                // Handle or log any potential exceptions while closing resources
                Logger.getLogger(DAOdb.class.getName()).log(Level.SEVERE, "Error closing resources", ex);
            }
        }
    }
    
    /**
     * Inserts a relation between an UnidadDidactica and an Enunciado into the
     * database.
     *
     * @param udId The ID of the UnidadDidactica.
     * @param enunciadoId The ID of the Enunciado.
     * @throws SQLException If a database access error occurs.
     * @throws ServerException If an application-specific server error occurs.
     * @author Ander Goirigolzarri Iturburu
     */
    @Override
    public void insertUDEnunciadoRelation(int udId, int enunciadoId) throws ServerException {
        try {
            con = conController.openConnection();

            stmt = con.prepareStatement("INSERT INTO `unidad_enunciado` (`unidads_id`,`enunciados_id`) VALUES (?,?)");

            stmt.setInt(1, udId);
            stmt.setInt(2, enunciadoId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

            // Log the exception for debugging purposes
            // Logger.getLogger(DAOdb.class.getName()).log(Level.SEVERE, null, e);
            // Rethrow the SQLException as a ServerException
            throw new ServerException(e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                // Handle or log any potential exceptions while closing resources
                Logger.getLogger(DAOdb.class.getName()).log(Level.SEVERE, "Error closing resources", ex);
            }
        }
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
			CallableStatement cst = con.prepareCall("INSERT INTO `enunciado` (`id`,`descripcion`, `nivel`, `disponible`, `ruta`) VALUES (?,?,?,?,?)");
			
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
    public void addConvocatoria(Convocatoria c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkConvocatoria(int idEnun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Convocatoria> showConvocatoria(int idEnun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*@Override
    public boolean addEnunciadoToConvocatoria(String Convo, int idEnun) throws IOException {
        return false;
    }*/
    
    
    public HashSet<Enunciado> getEnunciados() throws ServerException {
	ResultSet rs = null;
	HashSet<Enunciado> enunciadoSet = null;
            try {
			
                con = conController.openConnection();
		String OBTAINids = "SELECT * FROM enunciado";

		enunciadoSet = new HashSet();
		
		
		stmt = con.prepareStatement(OBTAINids);
		rs = stmt.executeQuery();

		while (rs.next()) {		
                    Enunciado enun = new Enunciado();
                    enun.setId(rs.getInt("id"));
                    enun.setDescripcion(rs.getString("descripcion"));
                    enun.setNivel(Dificultad.valueOf(rs.getString("nivel")));
                    enun.setRuta(rs.getString("ruta"));
                    enunciadoSet.add(enun);
		}		

		conController.closeConnection(stmt, con);

		} catch (SQLException e) {
                    throw new ServerException(e.getMessage());
		}
		
		return enunciadoSet;	
	}

    @Override
    public Set<UnidadDidactica> getAllUnidadDidactica() throws ServerException {
         try {
            allUD = new HashSet<UnidadDidactica>();

            con = conController.openConnection();

            stmt = con.prepareStatement("SELECT * FROM unidad");
            rset = stmt.executeQuery();

            while (rset.next()) {
                ud = new UnidadDidactica();

                ud.setId(rset.getInt("id"));
                ud.setAcronimo(rset.getString("acronimo"));
                ud.setTitulo(rset.getString("titulo"));
                ud.setEvaluacion(rset.getString("evaluacion"));
                ud.setDescripcion(rset.getString("descripcion"));

                allUD.add(ud);
            }
        } catch (SQLException e) {
            // Log the exception for debugging purposes
            Logger.getLogger(DAOdb.class.getName()).log(Level.SEVERE, null, e);
            // Rethrow the SQLException as a ServerException
            throw new ServerException(e.getMessage());
        } finally {
            try {
                if (cst != null) {
                    cst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                // Handle or log any potential exceptions while closing resources
                Logger.getLogger(DAOdb.class.getName()).log(Level.SEVERE, "Error closing resources", ex);
            }
        }
        return allUD;
    }

    @Override
    public Set<Convocatoria> getConvocatorias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addEnunciadoToConvocatoria(String idConvo, int idEnun) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
