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

    public void addUnidadDidactica(UnidadDidactica ud) throws ServerException;
    /**
     * Retrieves all UnidadDidactica objects from the database.
     *
     * @return A Set containing all UnidadDidactica objects retrieved from the
     * database.
     * @throws SQLException If a database access error occurs.
     * @throws ServerException If an application-specific server error occurs.
     * @author Ander Goirigolzarri Iturburu
     */
    public Set<UnidadDidactica> getAllUnidadDidactica() throws ServerException;

    /**
     * Inserts a relation between an UnidadDidactica and an Enunciado into the
     * database.
     *
     * @param udId The ID of the UnidadDidactica.
     * @param enunciadoId The ID of the Enunciado.
     * @throws SQLException If a database access error occurs.
     * @throws ServerException If an application-specific server error occurs.
     */
    public void insertUDEnunciadoRelation(int udId, int enunciadoId) throws ServerException;

    //dspublic Enunciado returnEnunciadofromUD(UnidadDidactica UD)throws SQLException, ServerException;


    void addEnunciado(Enunciado enunciado) throws ServerException;

    void checkUnidadDidactica();


    void showEnunciadoByUnidadDidactica();

    
    public Set<Convocatoria> showConvocatoria(int idEnun);
    public Set<Convocatoria> getConvocatorias();
    public boolean addEnunciadoToConvocatoria(String idConvo, int idEnun) throws IOException;
    public boolean checkConvocatoria(int idEnun)throws IOException, ClassNotFoundException;
    public void addConvocatoria(Convocatoria c);
    public HashSet<Enunciado> getEnunciados() throws ServerException;
    
}
