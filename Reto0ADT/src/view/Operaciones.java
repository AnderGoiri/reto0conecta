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
import util.Util;

/**
 *
 * @author 2dam
 */
public class Operaciones {
    
    public void CreateEnunciado(){
        
        Enunciado enun = new Enunciado();
        
        System.out.println("introduce id del enunciado");
        enun.setId(Util.leerInt());

        System.out.println("introduce descripcion del enunciado");
        enun.setDescripcion(Util.introducirCadena());
        
        System.out.println("introduce nivel del enunciado. 1:BAJA, 2:MEDIA, 3:ALTA");
        int dif = Util.leerInt(1, 3);
        switch(dif){
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
    
    public void CreateConvocatoria() {
    	Convocatoria conv = new Convocatoria();
        
        System.out.println("Introduce el nombre.");
        conv.setConvocatoria(Util.introducirCadena());

        System.out.println("Introduce la descripción.");
        conv.setDescripcion(Util.introducirCadena());
        
        System.out.println("Introduce la fecha.");
        conv.setFecha(Util.leerFechaDMA());
        
        System.out.println("Introduce el curso.");
        conv.setCurso(Util.introducirCadena());
        
        DAOFactory.getModel(0).();
        System.out.println("Introduce el id del enunciado asignado a esta convocatoria.");
        conv.setIdEnunciado(Util.leerInt());
        
        try {
            DAOFactory.getModel(1).addConvocatoria(conv);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void ShowConvocatoria() {
    	int idEnun = 0;
    	Set<Convocatoria> setConvo = new HashSet<Convocatoria>();
    	int i = 0;
    	
    	System.out.println("Introduce el id del enunciado asignado a la convocatoria que buscas.");
        idEnun = Util.leerInt();
        
        try {
            setConvo = DAOFactory.getModel(1).showConvocatoria(idEnun);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    
}