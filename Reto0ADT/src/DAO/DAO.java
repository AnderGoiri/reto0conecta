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
import java.io.IOException;
import model.Convocatoria;
import java.sql.SQLException;
import java.util.HashSet;
import model.Convocatoria;

/**
 *
 * @author 2dam
 */
public interface DAO {

    /**
     *
     * @return @throws java.lang.ServerException
     */

    public UnidadDidactica addUnidadDidactica()throws Exception;
    public void addConvocatoria(Convocatoria c);
    public void addEnunciado(Enunciado enunciado) throws ServerException;
    public void checkUnidadDidactica();
    public boolean checkConvocatoria(int idEnun)throws IOException, ClassNotFoundException;
    public void showEnunciadoByUnidadDidactica();
    public Set<Convocatoria> showConvocatoria(int idEnun);
    public Set<Convocatoria> getConvocatorias();
    public boolean addEnunciadoToConvocatoria(String idConvo, int idEnun) throws IOException;
    //void viewEnunciado();
    public HashSet<Enunciado> getEnunciados() throws ServerException;
    public Set<UnidadDidactica> getAllUnidadDidactica() throws SQLException, ServerException;

}
