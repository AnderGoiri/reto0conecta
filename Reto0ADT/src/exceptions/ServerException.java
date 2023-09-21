package exceptions;

import java.sql.SQLException;

public class ServerException extends Exception {

	public ServerException() {
		super();
	}
	public ServerException(String msg)
	{
		super(msg);
	}

    public ServerException(String a_server_error_occurred_while_executing_t, SQLException ex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
