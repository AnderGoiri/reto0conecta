/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplementation;

import DAO.DAO;
import exceptions.ServerException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Convocatoria;
import model.Dificultad;
import model.Enunciado;
import DAO.DAO;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import model.Convocatoria;
import model.UnidadDidactica;

/**
 * Implementation class aimed for the interaction with the Data Base
 * 
 * @author 2dam, Ander Goirigolzarri Iturburu
 */
public class DAOdb implements DAO {

    protected Connection con;
    protected PreparedStatement stmt;
    protected DBConnection conController = new DBConnection();
    protected ResultSet rset;
    protected CallableStatement cst;
    /**
     * Adds a new "UnidadDidactica" to the database.
     *
     * @param ud The UnidadDidactica object to be added.
     * @throws ServerException If there is an issue with the server during the
     * operation.
     * @throws SQLException If a database access error occurs or the SQL
     * execution fails.
     */

    public void addUnidadDidactica(UnidadDidactica ud) throws SQLException, ServerException {
        try {
            con = conController.openConnection();

            System.out.println("Introduce el código de la Unidad Didáctica:");
            int id = Integer.parseInt(Scanner.nextLine());

            System.out.println("Introduce el acrónimo de la Unidad Didáctica:");
            String acronimo = Scanner.nextLine();

            System.out.println("Introduce el título de la Unidad Didáctica:");
            String titulo = scanner.nextLine();

            System.out.println("Introduce el tipo de evaluación de la Unidad Didáctica:");
            String evaluacion = scanner.nextLine();

            System.out.println("Introduce la descripción de la Unidad Didáctica:");
            String descripcion = scanner.nextLine();

            UnidadDidactica UD = new UnidadDidactica(id, acronimo, titulo, evaluacion, descripcion);

            System.out.println("Código: " + UD.getId());
            System.out.println("Acrónimo: " + UD.getAcronimo());
            System.out.println("Título: " + UD.getTitulo());
            System.out.println("Evaluación: " + UD.getEvaluacion());
            System.out.println("Descripción: " + UD.getDescripcion());
            //AGI 20/09: Estaría bien implementar una confirmación antes de crear cada objeto. Podríamos usar los métodos de la clase Util que empleabamos el año pasado
            //System.out.println("¿Desea confirmar la creación de esta Unidad Didáctica?");
            cst = con.prepareCall("INSERT INTO `unidad` (`id`,`acronimo`, `titulo`, `evaluacion`, `descripcion`) VALUES (?,?,?,?,?)");
            
            cst.setInt(1, ud.getId());
            cst.setString(2, ud.getAcronimo());
            cst.setString(3, ud.getTitulo());
            cst.setString(4, ud.getEvaluacion());
            cst.setString(5, ud.getDescripcion());

            cst.execute();

        } catch (SQLException e) {
          throw new ServerException(e.getMessage());
        }
        
        conController.closeConnection(stmt, con);
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

            cst.setInt(1, enunciado.getId());
            cst.setString(2, enunciado.getDescripcion());
            cst.setString(3, enunciado.getNivel().toString());
            int disponible = enunciado.isDisponible() ? 1 : 0;
            cst.setInt(4, disponible);
            cst.setString(5, enunciado.getRuta());
            cst.execute();

        } catch (SQLException e) {
            throw new ServerException(e.getMessage());
        }

        conController.closeConnection(stmt, con);

    }

    public Set<Convocatoria> showConvocatoria() {
        return null;
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
    }
}
