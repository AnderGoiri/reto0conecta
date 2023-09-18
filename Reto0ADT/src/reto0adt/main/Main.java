/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0adt.main;

import controller.Controller;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author 2dam
 */
public class Main {
    
    public static void main(String[] args) {
       
        Controller cont = new Controller();
        cont.run();

       


        /*if (Desktop.isDesktopSupported()) {
    try {
        File myFile = new File("C:\\Users\\2dam\\Downloads\\2DAM_Reto0_Alumna_2023-24_Conecta.pdf");
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
    }
}*/
    }   
}
