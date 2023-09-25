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
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
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
     * Choose a "UnidadDidactica" from all the UnidadDidactica availables in the DataBase
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
     * @param allEnunciado: a Set with all the Enunciado
     * @return id: the Identity Number for the Enunciado
     * @author Ander Goirigolzarri Iturburu
     */
    public int chooseEnunciado(Set<Enunciado> allEnunciado){
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
    
}
