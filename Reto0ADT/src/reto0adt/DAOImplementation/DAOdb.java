/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0adt.DAOImplementation;

import java.util.Scanner;
import reto0adt.DAO.DAO;
import reto0adt.model.UnidadDidactica;

/**
 *
 * @author Ander Goirigolzarri Iturburu
 */
public class DAOdb implements DAO {

    @Override
    public UnidadDidactica addUnidadDidactica() throws Exception {
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
            

            return UD;
            

        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
            return null;
        }
    }

    @Override
    }

    @Override
    }

    @Override
    }

    @Override
    }

    @Override
    }

    @Override
    public void showConvocatoria() {
    }
}
