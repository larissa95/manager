package controller.database;

import java.sql.Connection;
import java.sql.Statement;

public class DataBaseTables {

	// this string array gives a good overview over the existing tables
	//To Do create links between tables
	static String[][] tables = {
			{ "Client", "Id INT PRIMARY KEY AUTO_INCREMENT NOT NULL",
					"Name VARCHAR(255)", "Email VARCHAR(255)" },
			{ "Employee", "Id INT PRIMARY KEY AUTO_INCREMENT NOT NULL",
					"Name VARCHAR(255) NOT NULL" },
			{ "Client_Employee_Link", "clientId INT NOT NULL",
					"employeeId INT NOT NULL",
					"FOREIGN KEY (clientId) REFERENCES Client(Id)",
					"FOREIGN KEY (employeeId) REFERENCES Employee(Id)",
					"PRIMARY KEY (clientId, employeeId)" },
			{ "Task", "Id INT PRIMARY KEY AUTO_INCREMENT NOT NULL",
					"Name VARCHAR(255)", "Description VARCHAR(255)",
					"startDate DATETIME", "deadline DATETIME", "Finished BIT",
					"payment INT" },
			{ "Work", "Id INT PRIMARY KEY AUTO_INCREMENT NOT NULL",
					"Name VARCHAR(255)", "employeeId INT NOT NULL",
					"FOREIGN KEY (employeeId) REFERENCES Employee(Id)",
					"taskId INT NOT NULL",
					"FOREIGN KEY (taskId) REFERENCES Task(Id)",
					"startDate DATETIME", "endDate DATETIME" },
			{ "ToDo", "Id INT PRIMARY KEY AUTO_INCREMENT NOT NULL",
					"Name VARCHAR(255)", "taskId INT NOT NULL",
					"FOREIGN KEY (taskId) REFERENCES Task(Id)",
					"costEstimate INT" }

	};

	/**
	 * create Tables in DataBase like string tables is structured
	 */
	public static void createTables(Connection dataBaseConnection) {
		try {
			Statement stmt = dataBaseConnection.createStatement();
			if (dataBaseConnection != null) {
				String createTable = null;
				for (String[] tab : tables) {
					StringBuilder colums = new StringBuilder();
					for (int i = 1; i < tab.length; i++) {
						colums.append(tab[i]);
						if (i != tab.length - 1) {
							colums.append(", ");
						}
					}
					createTable = "CREATE TABLE IF NOT EXISTS " + tab[0] + "("
							+ colums.toString() + ")";
					if (createTable != null) {
						stmt.executeUpdate(createTable);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
