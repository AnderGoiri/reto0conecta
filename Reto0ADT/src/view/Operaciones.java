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
    
}
