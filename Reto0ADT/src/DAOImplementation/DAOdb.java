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
import java.util.Set;
import model.Convocatoria;
import model.UnidadDidactica;

/**
 *
 * @author 2dam
 */
public class DAOdb implements DAO{

    protected Connection con;
    protected PreparedStatement stmt;
    protected DBConnection conController = new DBConnection();
        
    @Override
    public UnidadDidactica addUnidadDidactica() throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Introduce el código de la Unidad Didáctica:");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.println("Introduce el acrónimo de la Unidad Didáctica:");
            String acronimo = scanner.nextLine();

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
            
            return UD;
            
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
            return null;
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
    
    @Override
    public boolean addEnunciadoToConvocatoria(String Convo, int idEnun) throws IOException {
        return false;
    }
}
