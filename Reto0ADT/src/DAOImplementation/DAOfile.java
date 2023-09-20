/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplementation;

import model.Enunciado;
import DAO.DAO;
import exceptions.ServerException;

/**
 *
 * @author 2dam
 */
public class DAOfile implements DAO{

    

    @Override
    public void addConvocatoria() {
        
    }
    @Override
    public void checkConvocatoria() {
       
    }
    @Override
    public void showConvocatoria() {
        
    }
    
    @Override
    public UnidadDidactica addUnidadDidactica(int id, String acronimo, String titulo, String evaluacion, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
     public void addEnunciado(Enunciado enunciado) throws ServerException {}

    @Override
    public void checkUnidadDidactica() {}

    @Override
    public void showEnunciadoByUnidadDidactica() {}
    
}
