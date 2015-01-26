import java.sql.Connection;
import java.sql.SQLException;

import controller.database.DataBaseConnection;
import controller.database.DataBaseTables;

public class Main {

	public static void main(String[] args) {
		try {
			DataBaseConnection.getDataBaseConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
