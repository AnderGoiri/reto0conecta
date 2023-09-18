/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0adt.DAO;

import java.io.File;
import reto0adt.model.Convocatoria;
import reto0adt.model.Enunciado;
/**
 *
 * @author 2dam
 */
public interface DAO {
    void addUnidadDidactica();
    void addConvocatoria(File convocatorias, Convocatoria c);
    void addEnunciado();
    void checkUnidadDidactica();
    Convocatoria checkConvocatoria(Enunciado e);
    void showEnunciadoByUnidadDidactica();
    void showConvocatoria();
    //void viewEnunciado();
}
