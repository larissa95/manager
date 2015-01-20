package model;
import java.util.ArrayList;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
@DatabaseTable(tableName = "Client")

public class Client {
	
	    @DatabaseField (generatedId=true)
	    private int id;
	    
	    @DatabaseField
		private String name;
	    
	    @DatabaseField
	    private String email;
	    
	    //one to many relationship to task
	    @ForeignCollectionField
	    ArrayList<Task> tasks;
}
