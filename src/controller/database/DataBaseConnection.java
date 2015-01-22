package controller.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private static Connection dataBaseConnection = null;
	
	/**
	 *create a new database if there is no existing one and establish
	 *use the same dataBaseConnection for the whole program => Singleton-Pattern
	 * @return a connection to the database
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static Connection getDataBaseConnection() throws SQLException{
		if(dataBaseConnection == null){
		//	Class.forName("org.h2.Driver");
			dataBaseConnection = DriverManager
					.getConnection("jdbc:h2:~/manager;TRACE_LEVEL_FILE=0;TRACE_LEVEL_SYSTEM_OUT=1","username","123#passwortForDb#123");
		}
		return dataBaseConnection;
	}
	

	/**
	 * @param dataBaseConnection
	 *            closes dataBaseConnection
	 */
	public static void closeConnection(Connection dataBaseConnection) {
		try {
			dataBaseConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
	


