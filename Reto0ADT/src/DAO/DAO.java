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
import java.sql.SQLException;
import java.util.HashSet;
import model.Convocatoria;


/**
 *
 * @author 2dam
 */
public interface DAO {

    /**
     * Adds a new "UnidadDidactica" to the database.
     *
     * @param ud The UnidadDidactica object to be added.
     * @throws ServerException If there is an issue with the server during the
     * operation.
     * @throws SQLException If a database access error occurs or the SQL
     * execution fails.
     * @author Ander Goirigolzarri Iturburu
     */
    public void addUnidadDidactica(UnidadDidactica ud) throws ServerException, SQLException;

    /**
     * Retrieves all UnidadDidactica objects from the database.
     *
     * @return A Set containing all UnidadDidactica objects retrieved from the
     * database.
     * @throws SQLException If a database access error occurs.
     * @throws ServerException If an application-specific server error occurs.
     * @author Ander Goirigolzarri Iturburu
     */
    public Set<UnidadDidactica> getAllUnidadDidactica() throws ServerException, SQLException;

    /**
     * Inserts a relation between an UnidadDidactica and an Enunciado into the
     * database.
     *
     * @param udId The ID of the UnidadDidactica.
     * @param enunciadoId The ID of the Enunciado.
     * @throws SQLException If a database access error occurs.
     * @throws ServerException If an application-specific server error occurs.
     */
    public void insertUDEnunciadoRelation(int udId, int enunciadoId) throws SQLException, ServerException;

    public Enunciado returnEnunciadofromUD(UnidadDidactica UD)throws SQLException, ServerException;
    
    public HashSet<Enunciado> getAllEnunciadoFromUD(int udId) throws ServerException;

    void addConvocatoria(Convocatoria c);

    void addEnunciado(Enunciado enunciado) throws ServerException;

    void checkUnidadDidactica();

    Set<Convocatoria> checkConvocatoria(int idEnun);

    void showEnunciadoByUnidadDidactica();

    void showConvocatoria();
    //void viewEnunciado();
}
