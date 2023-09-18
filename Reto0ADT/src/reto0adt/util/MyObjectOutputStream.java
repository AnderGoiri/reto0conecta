/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0adt.util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
/**
 * 
 * @author Jagoba Bartolomé Barroso
 */
public class MyObjectOutputStream extends ObjectOutputStream{
		 //Sobrescribimos el metodo que crea la cabecera
		 protected void writeStreamHeader() throws IOException{
			 	reset();
		 }
		 //Constructores
		 public MyObjectOutputStream () throws IOException{
			 super();
		 }
		 public MyObjectOutputStream(OutputStream out) throws IOException{
			 super(out);
		 }
}
