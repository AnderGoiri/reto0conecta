/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Enunciado;
import model.UnidadDidactica;

import java.util.Set;

import exceptions.ServerException;
import model.Unidad;

/**
 *
 * @author 2dam
 */
public interface DAO {
     /**
     *
     * @return
     * @throws java.lang.Exception
     */

    public UnidadDidactica addUnidadDidactica()throws Exception;
    void addConvocatoria(Convocatoria c);
    void addEnunciado(Enunciado enunciado) throws ServerException;
    void checkUnidadDidactica();
    Set<Convocatoria> checkConvocatoria(int idEnun);
    void showEnunciadoByUnidadDidactica();
    void showConvocatoria();
    //void viewEnunciado();
}
