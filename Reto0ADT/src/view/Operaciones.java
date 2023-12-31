/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Factory.DAOFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Dificultad;
import model.Enunciado;
import exceptions.ServerException;
import java.util.HashSet;
import java.util.Set;
import model.Convocatoria;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import model.UnidadDidactica;
import util.Util;

/**
 *
 * @author 2dam
 */
public class Operaciones {

    /**
     * This method creates an object "Enunciado", sets its attributes and calls a method from the DB Implementation
     * @author Andoni Sanz Alcalde
     */
    public void createEnunciado() {

        Enunciado enun = new Enunciado();

        System.out.println("introduce id del enunciado");
        enun.setId(Util.leerInt());

        System.out.println("introduce descripcion del enunciado");
        enun.setDescripcion(Util.introducirCadena());

        System.out.println("introduce nivel del enunciado. 1:BAJA, 2:MEDIA, 3:ALTA");
        int dif = Util.leerInt(1, 3);
        switch (dif) {
            case 1:
                enun.setNivel(Dificultad.BAJA);
                break;
            case 2:
                enun.setNivel(Dificultad.MEDIA);
                break;
            case 3:
                enun.setNivel(Dificultad.ALTA);
                break;
        }

        System.out.println("esta el enunciado disponible");
        enun.setDisponible(Util.esBoolean());

        System.out.println("introduce ruta del enunciado");
        enun.setRuta(Util.introducirCadena());
       
        try {
            DAOFactory.getModel(0).addEnunciado(enun);
            
            Set<UnidadDidactica> udSet = DAOFactory.getModel(0).getAllUnidadDidactica();     
            for(UnidadDidactica ud : udSet){
                System.out.println(ud.getAcronimo());
            }
        
            boolean continue_ = false;
            UnidadDidactica udToInsert = null;
            do{
                
                System.out.println("Seleccione una unidad didactica");
                String udUser = Util.introducirCadena();
                  
                for(UnidadDidactica ud : udSet){
                    if(ud.getAcronimo().equalsIgnoreCase(udUser))
                    {
                        udToInsert = ud;
                        break; 
                    }
                }
                DAOFactory.getModel(0).insertUDEnunciadoRelation(udToInsert.getId(), enun.getId());
                
                System.out.println("Seguir añadiendo unidades didacticas?");
                continue_ = !Util.esBoolean();
            }while(!continue_);
             
            continue_ = false;
            Set<Convocatoria> convSet = DAOFactory.getModel(1).getConvocatorias();
            for(Convocatoria conv : convSet){
                System.out.println(conv.getConvocatoria());
            }
            
            Convocatoria convToInsert= null;
            do{
                
                System.out.println("Seleccione una convocatoria para asignarle un enunciado");
                String convUser = Util.introducirCadena();
                  
                for(Convocatoria conv: convSet){
                    if(conv.getConvocatoria().equalsIgnoreCase(convUser))
                    {
                        convToInsert = conv;
                        break; 
                    }
                }
                DAOFactory.getModel(1).addEnunciadoToConvocatoria(convUser, enun.getId());
                System.out.println("Seguir asignando enunciados a convocatorias?");
                continue_ = !Util.esBoolean();
            }while(!continue_);
             
             
        } catch (ServerException ex) {
            System.out.println("Ocurrio un error en la base de datos");
        } catch (IOException ex) {
            System.out.println("Ocurrio un error de input/output");
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada");
        }

    }
    /**
     * This method creates an object "UnidadDidactica", sets its attributes and calls a method from the DB Implementation
     * @author Ander Goirigolzarri Iturburu
     */
    public void createUnidadDidactica() {
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

            DAOFactory.getModel(0).addUnidadDidactica(UD);
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }
    
    /**
     * This method creates an object "Convocatoria", sets its attributes and calls a method from the File Implementation
     * @author Jagoba Bartolomé Barroso
     */
    public void createConvocatoria() {
    	Convocatoria conv = new Convocatoria();
        
        System.out.println("Introduce el nombre.");
        conv.setConvocatoria(Util.introducirCadena());

        System.out.println("Introduce la descripción.");
        conv.setDescripcion(Util.introducirCadena());
        
        System.out.println("Introduce la fecha.");
        conv.setFecha(Util.leerFechaDMA());
        
        System.out.println("Introduce el curso.");
        conv.setCurso(Util.introducirCadena());
        
        try {
            DAOFactory.getModel(1).addConvocatoria(conv);
        } catch (IOException ex) {
            System.out.println("Se ha producido un error con los flujos de entrada o salida.");
        }
    }
    /**
     * This method shows the wanted "Convocatoria" based on the "Enunciado" that the user selects.
     * @author Jagoba Bartolomé Barroso
     */
    public void showConvocatoria() {
    	int idEnun = 0;
    	Set<Convocatoria> setConvo = new HashSet<Convocatoria>();
        Set<Enunciado> setEnun = new HashSet<Enunciado>();
    	
        try {
            setEnun = DAOFactory.getModel(0).getEnunciados();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        for (Enunciado enun : setEnun){
            System.out.println("ID: " + enun.getId() + " Descripción: " + enun.getDescripcion() + " Nivel: " + enun.getNivel() + " Disponible: " + enun.isDisponible() + 
                    " Ruta: " + enun.getRuta());
        }
    	System.out.println("Introduce el id del enunciado asignado a la/las convocatoria que buscas.");
        idEnun = Util.leerInt();
        
        try {
            setConvo = DAOFactory.getModel(1).showConvocatoria(idEnun);
        } catch (IOException ex) {
            System.out.println("Se ha producido un error con los flujos de entrada o salida.");
        } catch (ClassNotFoundException e) {
        	System.out.println("Se ha producido un error.");
        }
        System.out.println("Estas son las convocatorias asignadas al enunciado introducido.");
         for (Convocatoria conv : setConvo){
            System.out.println("Convocatoria: " + conv.getConvocatoria() + " Descripción: " + conv.getDescripcion() + " Fecha: " + conv.getFecha() + " Curso: " + conv.getCurso() + 
                    " ID Enunciado asociado: " + conv.getIdEnunciado());
        }

    }
    /**
     * This method visualizes de data of all Enunciados and asks the user for the id to open one enunciado pdf
     * @author Andoni Sanz Alcalde
     */
    public void visualizeEnunciado(){
        HashSet<Enunciado> enunSet = null;
        try {
            enunSet = DAOFactory.getModel(0).getEnunciados();
        } catch (ServerException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Enunciado enun : enunSet){
            System.out.println("ID: "+enun.getId());
            System.out.println("DESCRIPCION: "+enun.getDescripcion());
            System.out.println("NIVEL: "+enun.getNivel().toString());
            System.out.println("DISPONIBLE: "+enun.isDisponible());
            System.out.println("RUTA: "+enun.getRuta()); 
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println("Escribe la ID del Enunciado a Visualizar");
        int numEnunciado = Util.leerInt();
        
        String ruta = new String();
        for(Enunciado enun : enunSet){
            if(enun.getId() == numEnunciado)
            {
                ruta = enun.getRuta();
                break;
            }
        }
        
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile;
                myFile = new File(ruta);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
    }

    /**
     * Choose a "UnidadDidactica" from all the UnidadDidactica availables in the
     * DataBase
     *
     * @param allUD: a Set with all the UnidadDidactica
     * @return acronimo: the shortenned name of the UnidadDidactica
     * @author Ander Goirigolzarri Iturburu
     */
    public String chooseUnidadDidactica(Set<UnidadDidactica> allUD) {
        System.out.println("Lista de Unidades Didácticas:");
        String acronimo;
        int index = 1;
        for (UnidadDidactica ud : allUD) {
            System.out.println(index + ". " + ud.getAcronimo());
            index++;
        }
        System.out.println("Elija una Unidad Didáctica(introduzca su acrónimo)");
        Scanner sc = new Scanner(System.in);
        acronimo = sc.next();
        return acronimo;
    }

    /**
     * Choose a "Enunciado" from all the Enunciado availables
     *
     * @param allEnunciado: a Set with all the Enunciado
     * @return id: the Identity Number for the Enunciado
     * @author Ander Goirigolzarri Iturburu
     */
    public int chooseEnunciado(Set<Enunciado> allEnunciado) {
        System.out.println("Lista de Enunciado:");
        int id;
        for (Enunciado enun : allEnunciado) {
            System.out.println(enun.getId());
        }
        System.out.println("Elija un Enunciado");
        Scanner sc = new Scanner(System.in);
        id = sc.nextInt();
        return id;
    }
 /**
     * Returns an Enunciado associated with a given Unidad Didactica (UD) and
     * chosen Enunciado ID.
     *
     * @param UD The Unidad Didactica for which an Enunciado is to be retrieved.
     * @return The Enunciado associated with the provided Unidad Didactica and
     * Enunciado ID, or null if not found.
     *
     * @author Ander Goirigolzarri Iturburu
     */
    public void returnEnunciadofromUD() {
        try {
            Set<UnidadDidactica> allUD = new HashSet<>();
            allUD = DAOFactory.getModel(0).getAllUnidadDidactica();
            String auxAcronimoUD = chooseUnidadDidactica(allUD);

            int udId = 0;
            for (UnidadDidactica unidad : allUD) {
                if (unidad.getAcronimo().equalsIgnoreCase(auxAcronimoUD)) {
                    udId = unidad.getId();
                }
            }
            Set<Enunciado> allEnunciado = new HashSet<>();
            allEnunciado = DAOFactory.getModel(0).getAllEnunciadoFromUD(udId);

            int auxEnunciadoId = chooseEnunciado(allEnunciado);
            Enunciado enunciado = null;
            for (Enunciado enun : allEnunciado) {
                if (enun.getId() == auxEnunciadoId) {
                    enunciado = enun;
                }
            }
            
            System.out.println("ID: "+enunciado.getId());
            System.out.println("DESCRIPCION: "+enunciado.getDescripcion());
            System.out.println("NIVEL: "+enunciado.getNivel().toString());
            System.out.println("DISPONIBLE: "+enunciado.isDisponible());
            System.out.println("RUTA: "+enunciado.getRuta()); 
        } catch (ServerException ex) {
            System.err.println("Ocurrio un error en la base de datos");
        }
    }
    
}
