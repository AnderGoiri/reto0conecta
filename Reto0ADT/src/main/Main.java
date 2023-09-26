/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.Controller;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author 2dam
 */
public class Main extends Application{
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
       System.out.println("java.version: "+System.getProperty("java.version"));
        Controller cont = new Controller();
        cont.run();
    }   

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
