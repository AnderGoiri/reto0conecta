/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0adt.DAOImplementation;

import reto0adt.DAO.DAO;
import reto0adt.model.UnidadDidactica;

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
    
    public void addUnidadDidactica() {}
    
    @Override
    public void addEnunciado() {}

    @Override
    public void checkUnidadDidactica() {}

    @Override
    public void showEnunciadoByUnidadDidactica() {}

    @Override
    public UnidadDidactica addUnidadDidactica(int id, String acronimo, String titulo, String evaluacion, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
