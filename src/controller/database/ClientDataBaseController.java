package controller.database;

import java.sql.ResultSet;
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

			if (dataBaseConnection != null) {

				String insertQuery = "INSERT INTO Client (id, Name, Email) VALUES (null,?,?)";
				// TBD if(employee/task list is not empty => add links in
				// database)
				PreparedStatement pstmt = dataBaseConnection.prepareStatement(
						insertQuery, Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, client.getName());
				pstmt.setString(2, client.getEmail());
				pstmt.executeUpdate();
				ResultSet keys = pstmt.getGeneratedKeys();
				// if the client is inserted, the id in the database is returned
				// here
				if (keys.next()) {
					keyID = keys.getInt(1);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return keyID;
	}

	/**
	 * loads Client from database
	 * 
	 * @return specific client for id (which is saved in database)
	 */
	public static Client loadClient(int clientId) {
		Connection dataBaseConnection;
		try {
			dataBaseConnection = DataBaseConnection.getDataBaseConnection();

			if (dataBaseConnection != null) {
				String selectSQL = "SELECT * FROM Client WHERE id = ?";
				PreparedStatement pstmt = dataBaseConnection
						.prepareStatement(selectSQL);
				pstmt.setInt(1, clientId);
				// execute the Query
				ResultSet rs = pstmt.executeQuery();
				Client client = null;
				if (rs.next()) {
					// TBD also read tasks and employee links here => from link
					// dataBaseController
					client = new Client.ClientBuilder(rs.getString("Name"))
							.id(rs.getInt("Id")).email(rs.getString("Email"))
							.createClient();
				}
				return client;
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return null;
	}
}
