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

	public DBConnection() {
		configFile = ResourceBundle.getBundle("Config");
		url = configFile.getString("URL");
		user = configFile.getString("USER");
		pass = configFile.getString("PASSWORD");
	}

	public Connection openConnection() throws ServerException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}
		return con;
	}

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
