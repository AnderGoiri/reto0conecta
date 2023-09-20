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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;
import reto0adt.model.Convocatoria;
import reto0adt.model.Enunciado;
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
                } catch (IOException e) {

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

    /**
     *
     * @param convocatorias
     * @param e
     * @return
     */
    @Override
    public Set<Convocatoria> checkConvocatoria(File convocatorias, Enunciado e) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        int numConvocatorias = Util.calculoFichero(convocatorias);
        Convocatoria c = null;
        Set<Enunciado> setEnun = new HashSet<Enunciado>();
        Enunciado enun = null;
        Set<Convocatoria> setConvo = new HashSet<Convocatoria>();
        
        if (convocatorias.exists()){
            try {
                ois = new ObjectInputStream(new FileInputStream(convocatorias));
                for (int i = 0; i < numConvocatorias; i++){
                    c = (Convocatoria) ois.readObject();
                    setEnun = c.getSetEnunciados();
                    for (Enunciado en : setEnun){
                        if (en.equals(enun)){
                            
                        }
                    }
                }
                
            } catch(Exception x) {
                
            }
        }
        return c;
    }

    @Override
    public void showConvocatoria() {

    }
   
    @Override
    public void showEnunciadoByUnidadDidactica() {}
    
}
