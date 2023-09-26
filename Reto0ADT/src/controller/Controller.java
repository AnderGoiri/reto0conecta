/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAO;
import view.Menu;
import view.Operaciones;
import util.Util;

/**
 *
 * @author 2dam
 */
public class Controller {
    
    private Menu menu;
    
    public Controller(){}
    
    public void run(){
        
        int opc = 0;
        Operaciones operaciones = new Operaciones();
        menu = new Menu();
        
        String enunciadoExamen = "1. Crear una unidad didáctica.\n" +
                                 "2. Crear Convocatoria.\n" +
                                 "3. Crear Enunciado.\n" +
                                 "4. Consultar Enunciado en los que se trata una unidad didactica concreta.\n" +
                                 "5. Consultar Convocatoria en las que se ha utilizado un enunciado concreto.\n" +
                                 "6. Visualizar documento de texto asociado a un enunciado.";
        menu.setMenuOptions(enunciadoExamen);
         
        do{
         System.out.println(menu.getMenuOptions());  
           
        opc = Util.leerInt(1, 9);
        switch (opc) {
			case 1:
                                operaciones.createUnidadDidactica();
				break;
			case 2:
				operaciones.CreateConvocatoria();
				break;
			case 3:
				operaciones.createEnunciado();
				break;
			case 4:
				
				break;
			case 5:
                                operaciones.ShowConvocatoria();
				break;
                        case 6:
                                operaciones.visualizeEnunciado();
				break;       
                        case 7:
                        default:
				break;
			}
        
        }while(opc != 7);
  
    }
}
