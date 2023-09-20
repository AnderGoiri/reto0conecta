/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Enunciado;
import exceptions.ServerException;

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
    void addConvocatoria();
    void addEnunciado(Enunciado enunciado) throws ServerException;
    void checkUnidadDidactica();
    void checkConvocatoria();
    void showEnunciadoByUnidadDidactica();
    void showConvocatoria();
    //void viewEnunciado();
}
