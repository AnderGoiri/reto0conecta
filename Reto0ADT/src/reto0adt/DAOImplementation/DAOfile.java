/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0adt.DAOImplementation;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import reto0adt.DAO.DAO;
import java.io.File;
import reto0adt.model.Convocatoria;
import reto0adt.util.MyObjectOutputStream;
import reto0adt.util.Util;
/**
 *
 * @author Jagoba Bartolomé Barroso
 */
public class DAOfile implements DAO{
    
    @Override
    public void addUnidadDidactica() {
    }

    @Override
    public void addConvocatoria(File convocatorias, Convocatoria c) {
        FileOutputStream fos = null;
        ObjectOutputStream moos = null;

        if (convocatorias.exists()) {
            try {
                fos = new FileOutputStream(convocatorias, true);
                moos = new MyObjectOutputStream(fos);
                do {
                    moos.writeObject(c);
                } while (Util.esBoolean());
            } catch (Exception e) {

            } finally {
                try {
                    moos.flush();
                    moos.close();
                    fos.close();
                } catch (Exception e) {

                }
            }
        } else {
            ObjectOutputStream oos = null;
            try {
                fos = new FileOutputStream(convocatorias);
                oos = new ObjectOutputStream(fos);
                System.out.println();
                do {
                    oos.writeObject(c);
                } while (Util.esBoolean());
            } catch (Exception e) {

            } finally {
                try {
                    oos.flush();
                    oos.close();
                    fos.close();
                } catch (Exception e) {

                }
            }
        }
    }
    
    @Override
    public void addEnunciado() {
    }
    
    @Override
    public void checkUnidadDidactica() {}

    @Override
    public Convocatoria checkConvocatoria(reto0adt.model.Enunciado e) {
        
        
        return null;
    }

    @Override
    public void showConvocatoria() {

    }
   
    @Override
    public void showEnunciadoByUnidadDidactica() {}
    
}
