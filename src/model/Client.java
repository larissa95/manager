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
	 //   @ForeignCollectionField
	 //   ArrayList<Task> tasks;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
/*
		public ArrayList<Task> getTasks() {
			return tasks;
		}

		public void setTasks(ArrayList<Task> tasks) {
			this.tasks = tasks;
		}
	*/    
}
