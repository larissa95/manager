import java.sql.Connection;
import java.sql.SQLException;

import model.Client;
import controller.database.ClientDataBaseController;
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
		Client client = new Client("Frederik","Horcshc");
	}
	
}
