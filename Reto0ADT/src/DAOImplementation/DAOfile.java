/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplementation;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import reto0adt.DAO.DAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Convocatoria;
import model.Enunciado;
import util.MyObjectOutputStream;
import util.Util;
/**
 *
 * @author Jagoba Bartolomé Barroso
 */
public class DAOfile implements DAO{
    private File convocatorias = new File("convocatorias.obj");
    
    @Override
    public void addUnidadDidactica() {
    }
    
    /**
     * 
     * @param convocatorias
     * @param c 
     * This method takes the newly created Convocatoria c and adds it to a file named convocatorias
     */
    public void addConvocatoria(Convocatoria c) {
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
     * @param idEnun
     */
    
    @Override
    public boolean checkConvocatoria(int idEnun) throws IOException, ClassNotFoundException{
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        int numConvocatorias = Util.calculoFichero(convocatorias);
        boolean encontrado = false;
        Convocatoria c = null;
        
        if (convocatorias.exists()){
            try {
                ois = new ObjectInputStream(new FileInputStream(convocatorias));
                for (int i = 0; i < numConvocatorias; i++){
                    c = (Convocatoria) ois.readObject();
                    if (idEnun == c.getIdEnunciado()){
                        encontrado = true;
                        i = numConvocatorias;
                    }
                }
            } catch (IOException ex) {
                
            } catch (ClassNotFoundException ex) {
               
            }
        }
        return encontrado;
    }
    /**
     * 
     * @param idEnun
     * @return Set de Convocatoria
     */
    public Set<Convocatoria> showConvocatoria(int idEnun) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        int numConvocatorias = Util.calculoFichero(convocatorias);
        
        Convocatoria c = null;
        Set<Convocatoria> setConvo = new HashSet<Convocatoria>();
        
        if (convocatorias.exists()){
            try {
                ois = new ObjectInputStream(new FileInputStream(convocatorias));
                for (int i = 0; i < numConvocatorias; i++){
                    c = (Convocatoria) ois.readObject();
                    if (idEnun == c.getIdEnunciado()){
                        setConvo.add(c);
                    }
                }
            } catch (IOException ex) {
                
            } catch (ClassNotFoundException ex) {
               
            }
        }
        return setConvo;
    }
   
    @Override
    public void showEnunciadoByUnidadDidactica() {}
    
}
