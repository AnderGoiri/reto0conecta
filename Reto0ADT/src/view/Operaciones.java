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
import java.util.HashSet;
import java.util.Scanner;
import model.UnidadDidactica;
import util.Util;

/**
 *
 * @author 2dam
 */
public class Operaciones {

    public void CreateEnunciado() {

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
        } catch (ServerException ex) {
            System.out.println(ex.getMessage());
        }

    }

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
            System.out.println(e.getMessage());
        }
    }
    
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
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
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
            System.out.println("ID: " + enun.getId() + "Descripción: " + enun.getDescripcion() + "Nivel: " + enun.getNivel() + "Disponible: " + enun.isDisponible() + 
                    "Ruta: " + enun.getRuta());
        }
    	System.out.println("Introduce el id del enunciado asignado a la/las convocatoria que buscas.");
        idEnun = Util.leerInt();
        
        try {
            setConvo = DAOFactory.getModel(1).showConvocatoria(idEnun);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Estas son las convocatorias asignadas al enunciado introducido.");
         for (Convocatoria conv : setConvo){
            System.out.println("Convocatoria: " + conv.getConvocatoria() + "Descripción: " + conv.getDescripcion() + "Fecha: " + conv.getFecha() + "Curso: " + conv.getCurso() + 
                    "ID Enunciado asociado: " + conv.getIdEnunciado());
        }
    }

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
}

