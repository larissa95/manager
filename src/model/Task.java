package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Task")
public class Task {

    //many to one relationship to client, automatically mapped?
	@DatabaseField (foreign = true, foreignAutoRefresh = true)
    private Client client;
	
	
}
