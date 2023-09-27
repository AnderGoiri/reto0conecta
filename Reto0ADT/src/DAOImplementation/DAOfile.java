/*
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
     * This method adds an object "Convocatoria" to the file "convocatorias"
     * @param c 
     * This method takes the newly created Convocatoria c and adds it to a file named convocatorias
     * @throws IOException, FileNotFoundException 
     */
    public void addConvocatoria(Convocatoria c) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream moos = null;

        if (convocatorias.exists()) {
            try {
                fos = new FileOutputStream(convocatorias, true);
                moos = new MyObjectOutputStream(fos);
                moos.writeObject(c);
			} catch (IOException e) {
				throw new IOException();
			} finally {
                try {
                    moos.flush();
                    moos.close();
                    fos.close();
                } catch (IOException e) {
                	throw new IOException();
                }
            }
        } else {
            ObjectOutputStream oos = null;
            try {
                fos = new FileOutputStream(convocatorias);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(c);
            } catch (IOException e) {
				throw new IOException();
            } finally {
                try {
                    oos.flush();
                    oos.close();
                    fos.close();
                } catch (IOException e) {
                	throw new IOException();
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
     * This method checks if an object "Convocatoria" has an id from "Enunciado" associated with it. Returns a boolean.
     * @param idEnun
     * @return 
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
            	throw new IOException();
            }finally {
                try {
                    ois.close();
                    fis.close();
                } catch (IOException e) {
                	throw new IOException();
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
     * This method returns a set of "Convocatoria" that have an id from "Enunciado" in their attributes
     * @param idEnun
     * @return 
     * @throws ClassNotFoundException 
     * @throws IOException 
     */
    @Override
    public Set<Convocatoria> showConvocatoria(int idEnun) throws ClassNotFoundException, IOException {
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
            	throw new IOException();
            } catch (ClassNotFoundException e) {
				throw new ClassNotFoundException();
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
     * This method reads the file "convocatorias" and returns a set of "Convocatoria" 
     * @return
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    @Override
    public Set<Convocatoria> getConvocatorias() throws IOException, ClassNotFoundException {
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
            	throw new IOException();
            } catch (ClassNotFoundException e) {
            	throw new ClassNotFoundException();
			} finally {
                try {
                    ois.close();
                    fis.close();
                } catch (IOException e) {
                	throw new IOException();
                }
            }
        }
        return setConvo;
    }
    
    /**
     * This method adds an existing id from "Enunciado" into an object "Convocatoria"
     * @param Convo
     * @param idEnun
     * @return
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    @Override
    public boolean addEnunciadoToConvocatoria(String Convo, int idEnun) throws IOException, ClassNotFoundException{
        FileOutputStream fos = null;
        ObjectOutputStream moos = null;
        ObjectInputStream ois = null;
        int numConvocatorias = Util.calculoFichero(convocatorias);
        boolean exists = false;
        
        Convocatoria c = null;
        
        if (convocatorias.exists()){
            try {
                ois = new ObjectInputStream(new FileInputStream(convocatorias));
                for (int i = 0; i < numConvocatorias; i++){
                    c = (Convocatoria) ois.readObject();
                    if (Convo.equals(c.getConvocatoria()) ){
                        c.setIdEnunciado(idEnun);
                        i = numConvocatorias;
                        exists = true;
                    }
                }  
                try {
                	ois.close();
                } catch (IOException e){
                	throw new IOException();
                }
                if (exists == true){
                    fos = new FileOutputStream(convocatorias, true);
                    moos = new MyObjectOutputStream(fos);  
                    moos.writeObject(c);
                }
            } catch (IOException ex) {
            	throw new IOException();
            } catch (ClassNotFoundException ex) {
            	throw new ClassNotFoundException();
            } finally {
                try {
                    moos.flush();
                    moos.close();
                    fos.close();
                } catch (IOException e){
                	throw new IOException();
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
	public Set<UnidadDidactica> getAllUnidadDidactica() throws SQLException, ServerException {
		// TODO Auto-generated method stub
		return null;
	}
    
}