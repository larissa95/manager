import java.sql.SQLException;

import model.Client;
import controller.database.ClientDataBaseController;
import controller.database.DataBaseConnection;

public class Main {

	public static void main(String[] args) {
		System.out.println("test");

		try {
			DataBaseConnection.getDataBaseConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Client test = new Client.ClientBuilder("Fre").email("123").createClient();
		System.out.println(ClientDataBaseController.loadClient(test.getId()).getName());
	}
	
}
