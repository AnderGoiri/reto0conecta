/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0adt.DAO;

import reto0adt.model.UnidadDidactica;

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
    public void addConvocatoria();
    public void addEnunciado();
    public void checkUnidadDidactica();
    public void checkConvocatoria();
    public void showEnunciadoByUnidadDidactica();
    public void showConvocatoria();
    //void viewEnunciado();
}
