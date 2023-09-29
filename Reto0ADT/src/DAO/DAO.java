/**
 * Esta interfaz define las operaciones que pueden realizarse en la base de datos
 * relacionadas con las entidades UnidadDidactica, Enunciado y Convocatoria.
 * Cada método en esta interfaz representa una operación específica que puede
 * llevarse a cabo en la base de datos.
 *
 * @author 2dam
 */
package DAO;

import model.Enunciado;
import model.UnidadDidactica;
import java.util.Set;
import exceptions.ServerException;
import java.io.IOException;
import java.util.HashSet;
import model.Convocatoria;

public interface DAO {

    /**
     * Agrega una UnidadDidactica a la base de datos.
     *
     * @param ud La UnidadDidactica que se agregará a la base de datos.
     * @throws ServerException Si ocurre un error específico de la aplicación.
     */
    public void addUnidadDidactica(UnidadDidactica ud) throws ServerException;

    /**
     * Recupera todas las UnidadDidactica desde la base de datos.
     *
     * @return Un conjunto que contiene todas las UnidadDidactica recuperadas
     *         desde la base de datos.
     * @throws ServerException Si ocurre un error específico de la aplicación.
     */
    public Set<UnidadDidactica> getAllUnidadDidactica() throws ServerException;

    /**
     * Inserta una relación entre una UnidadDidactica y un Enunciado en la base de datos.
     *
     * @param udId El ID de la UnidadDidactica.
     * @param enunciadoId El ID del Enunciado.
     * @throws ServerException Si ocurre un error específico de la aplicación.
     */
    public void insertUDEnunciadoRelation(int udId, int enunciadoId) throws ServerException;

    //dspublic Enunciado returnEnunciadofromUD(UnidadDidactica UD)throws SQLException, ServerException;

    /**
     * Agrega un Enunciado a la base de datos.
     *
     * @param enunciado El Enunciado que se agregará a la base de datos.
     * @throws ServerException Si ocurre un error específico de la aplicación.
     */
    void addEnunciado(Enunciado enunciado) throws ServerException;

    /**
     * Agrega una Convocatoria a la base de datos.
     *
     * @param c La Convocatoria que se agregará a la base de datos.
     * @throws IOException Si ocurre un error de E/S.
     */
    public void addConvocatoria(Convocatoria c) throws IOException;

    /**
     * Verifica la existencia de una Convocatoria en función del ID de Enunciado.
     *
     * @param idEnun El ID del Enunciado.
     * @return true si existe una Convocatoria relacionada con el ID de Enunciado.
     * @throws IOException Si ocurre un error de E/S.
     * @throws ClassNotFoundException Si la clase no se encuentra.
     */
    public boolean checkConvocatoria(int idEnun) throws IOException, ClassNotFoundException;

    /**
     * Muestra Convocatoria por ID de Enunciado.
     *
     * @param idEnun El ID del Enunciado.
     * @return Un conjunto de Convocatorias relacionadas con el ID de Enunciado.
     * @throws ClassNotFoundException Si la clase no se encuentra.
     * @throws IOException Si ocurre un error de E/S.
     */
    public Set<Convocatoria> showConvocatoria(int idEnun) throws ClassNotFoundException, IOException;

    /**
     * Obtiene todas las Convocatorias desde la base de datos.
     *
     * @return Un conjunto de todas las Convocatorias en la base de datos.
     * @throws IOException Si ocurre un error de E/S.
     * @throws ClassNotFoundException Si la clase no se encuentra.
     */
    public Set<Convocatoria> getConvocatorias() throws IOException, ClassNotFoundException;

    /**
     * Agrega un Enunciado a una Convocatoria en la base de datos.
     *
     * @param idConvo El ID de la Convocatoria.
     * @param idEnun El ID del Enunciado.
     * @return true si se agregó con éxito, false en caso contrario.
     * @throws IOException Si ocurre un error de E/S.
     * @throws ClassNotFoundException Si la clase no se encuentra.
     */
    public boolean addEnunciadoToConvocatoria(String idConvo, int idEnun) throws IOException, ClassNotFoundException;

    /**
     * Obtiene un conjunto de Enunciados desde la base de datos.
     *
     * @return Un conjunto de Enunciados desde la base de datos.
     * @throws ServerException Si ocurre un error específico de la aplicación.
     */
    public HashSet<Enunciado> getEnunciados() throws ServerException;

    /**
     * Obtiene un conjunto de todos los Enunciados relacionados con una UnidadDidactica específica.
     *
     * @param udId El ID de la UnidadDidactica.
     * @return Un conjunto de Enunciados relacionados con la UnidadDidactica especificada.
     * @throws ServerException Si ocurre un error específico de la aplicación.
     */
    public HashSet<Enunciado> getAllEnunciadoFromUD(int udId) throws ServerException;
}
