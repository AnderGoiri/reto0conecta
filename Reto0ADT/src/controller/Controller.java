/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import reto0adt.DAO.DAO;
import reto0adt.view.Menu;
import reto0adt.view.Operaciones;
import util.Util;

/**
 *
 * @author 2dam
 */
public class Controller {
    
    Menu menu;
    
    public void run(){
        
        int opc = 0;
        Operaciones operaciones = new Operaciones();
        menu = new Menu();
        
        String enunciadoExamen = "1. Crear una unidad didáctica y convocatoria (Convocatoria) de examen.\n" +
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
                            
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
	
				break;
                        case 6:
 
				break;       
                        case 7:
                        default:
				break;
			}
        
        }while(opc != 7);
        
        
        
    }
}
