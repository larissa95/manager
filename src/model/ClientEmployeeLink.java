package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ClientEmployeeLink")
public class ClientEmployeeLink {
	 @DatabaseField(generatedId = true)
	 private int id;
	 @DatabaseField(foreign = true)
	 private Client client;
     @DatabaseField(foreign = true)
	 private Employee employee;

}
