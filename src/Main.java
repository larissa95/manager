import java.sql.Statement;
import java.sql.Connection;

import controller.database.DataBaseConnection;
import controller.database.DataBaseTables;

public class Main {

	public static void main(String[] args) {
		DataBaseTables.createTables();
	}
	
}
