package controller.database;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Client;

public class ClientDataBaseController {

	
	/**
	 * inserts Client to database
	 * 
	 * @param client
	 * @return id of the client in the database (primary key)
	 */
	
	
	public static int insertClient(Client client) {
		
		Connection dataBaseConnection;
		int keyID = -1;
		try {
			dataBaseConnection = DataBaseConnection.getDataBaseConnection();
		
		if(dataBaseConnection != null){
			String insertQuery = String.format(
					"INSERT INTO Client VALUES(null,'test' , 'test@')"
					);
			PreparedStatement pstmt = dataBaseConnection.prepareStatement(
					insertQuery, Statement.RETURN_GENERATED_KEYS);
			keyID = pstmt.executeUpdate();
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(keyID);
		return keyID;
	}
}
