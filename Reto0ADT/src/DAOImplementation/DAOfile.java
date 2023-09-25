/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplementation;

import DAO.DAO;
import exceptions.ServerException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import DAO.DAO;
import exceptions.ServerException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Convocatoria;
import model.Enunciado;
import model.UnidadDidactica;
import util.MyObjectOutputStream;
import util.Util;
/**
 *
 * @author Jagoba Bartolomé Barroso
 */
public class DAOfile implements DAO{
    private File convocatorias = new File("convocatorias.obj");
    
    public UnidadDidactica addUnidadDidactica() {
        return null;
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
                moos.writeObject(c);
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
                oos.writeObject(c);
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
    public void addEnunciado(Enunciado enun) {
    }

    @Override
    public void checkUnidadDidactica() {}

    /**
     *
     * @param idEnun
     * @return boolean
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
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
               
            }finally {
                try {
                    ois.close();
                    fis.close();
                } catch (Exception e) {

                }
            }
        }
        return encontrado;
    }
    
    @Override
    public void showEnunciadoByUnidadDidactica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @param idEnun
     * @return Set de Convocatoria
     */
    @Override
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
               
            } finally {
                try {
                    ois.close();
                    fis.close();
                } catch (Exception e) {

                }
            }
        }
        return setConvo;
    }
    @Override
    public Set<Convocatoria> getConvocatorias() {
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
                    setConvo.add(c);
                }
            } catch (IOException ex) {
                
            } catch (ClassNotFoundException ex) {
               
            } finally {
                try {
                    ois.close();
                    fis.close();
                } catch (Exception e) {

                }
            }
        }
        return setConvo;
    }
    
    /**
     * 
     * @param Convo
     * @param idEnun
     * @return
     * @throws IOException 
     */
    @Override
    public boolean addEnunciadoToConvocatoria(String Convo, int idEnun) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream moos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        int numConvocatorias = Util.calculoFichero(convocatorias);
        boolean exists = false;
        
        Convocatoria c = null;
        
        if (convocatorias.exists()){
            try {
                ois = new ObjectInputStream(new FileInputStream(convocatorias));
                for (int i = 0; i < numConvocatorias; i++){
                    c = (Convocatoria) ois.readObject();
                    if (Convo == c.getConvocatoria()){
                        c.setIdEnunciado(idEnun);
                        i = numConvocatorias;
                        exists = true;
                    }
                }  
                if (exists == true){
                    fos = new FileOutputStream(convocatorias, true);
                    moos = new MyObjectOutputStream(fos);  
                    moos.writeObject(c);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DAOfile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DAOfile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DAOfile.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    moos.flush();
                    moos.close();
                    fos.close();
                } catch (Exception e){
                    
                }
            }
        }
        return exists;
    }
    
    @Override
    public HashSet<Enunciado> getEnunciados() throws ServerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<UnidadDidactica> getAllUnidadDidactica() throws ServerException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertUDEnunciadoRelation(int udId, int enunciadoId) throws SQLException, ServerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
