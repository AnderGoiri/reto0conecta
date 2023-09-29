/**
 * Esta clase proporciona métodos para gestionar la conexión y cierre de la base de datos.
 * Utiliza un archivo de propiedades para obtener la información de configuración de la base de datos.
 */
package DAOImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import exceptions.ServerException;

public class DBConnection {
    private ResourceBundle configFile;
    private String url;
    private String user;
    private String pass;

    /**
     * Constructor que inicializa la clase DBConnection.
     * Lee la información de configuración de la base de datos desde un archivo de propiedades.
     */
    public DBConnection() {
        configFile = ResourceBundle.getBundle("Config");
        url = configFile.getString("URL");
        user = configFile.getString("USER");
        pass = configFile.getString("PASSWORD");
    }

    /**
     * Abre una conexión a la base de datos.
     *
     * @return Objeto Connection que representa la conexión a la base de datos.
     * @throws ServerException Si ocurre un error al intentar establecer la conexión.
     */
    public Connection openConnection() throws ServerException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new ServerException(e.getMessage());
        }
        return con;
    }

    /**
     * Cierra una conexión a la base de datos y una sentencia preparada (PreparedStatement).
     *
     * @param stmt Objeto PreparedStatement que se cerrará. Puede ser nulo.
     * @param con  Objeto Connection que se cerrará. Puede ser nulo.
     * @throws ServerException Si ocurre un error al intentar cerrar la conexión o la sentencia preparada.
     */
    public void closeConnection(PreparedStatement stmt, Connection con) throws ServerException {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new ServerException(e.getMessage());
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                throw new ServerException(e.getMessage());
            }
        }
    }
}
