/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0adt.DAO;

/**
 *
 * @author 2dam
 */
public interface DAO {
    void addUnidadDidactica();
    void addConvocatoria();
    void addEnunciado();
    void checkUnidadDidactica();
    void checkConvocatoria();
    void showEnunciadoByUnidadDidactica();
    void showConvocatoria();
    //void viewEnunciado();
}