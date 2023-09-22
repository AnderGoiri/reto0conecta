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
import model.Convocatoria;

/**
 *
 * @author 2dam
 */
public interface DAO {

    /**
     *
     * @return @throws java.lang.ServerException
     * @param ud
     * @throws exceptions.ServerException @throws java.lang.ServerException
     * @throws java.sql.SQLException
     */
    public void addUnidadDidactica(UnidadDidactica ud) throws ServerException, SQLException;

    public void addUnidadDidactica(UnidadDidactica ud) throws ServerException,SQLException;
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

    void addConvocatoria(Convocatoria c);

    void addEnunciado(Enunciado enunciado) throws ServerException;

    void checkUnidadDidactica();

    Set<Convocatoria> checkConvocatoria(int idEnun);

    void showEnunciadoByUnidadDidactica();

    void showConvocatoria();
    //void viewEnunciado();
}
