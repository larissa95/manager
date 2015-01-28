package model;
import java.util.ArrayList;

import controller.database.ClientDataBaseController;

public class Client {

	    private int id;
	    private String name;
	    private String email;

	    public Client(String name, String email){
	    	this.name = name;
	    	this.email = email;
	    	//has to be at the end of the constructor, as the values afterwards are not set in database
	    	this.id = ClientDataBaseController.insertClient(this);
	    }
	    
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
  
}
