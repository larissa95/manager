package model;

import java.util.ArrayList;

import controller.database.ClientDataBaseController;

public class Client {

	    private int id;
	    private String name;
	    private String email;
	    private ArrayList<Employee> employees = new ArrayList<Employee>();
	    private ArrayList<Task> tasks = new ArrayList<Task>();


	    public Client(String name, String email, ArrayList<Employee> employees, ArrayList<Task> tasks){
	    	this.name = name;
	    	this.email = email;
	    	this.employees = employees;
	    	this.tasks = tasks;
	    	//has to be at the end of the constructor, as the values afterwards are not set in database
	    	this.id = ClientDataBaseController.insertClient(this);
	    }
	    
	    public Client(int id, String name, String email, ArrayList<Employee> employees, ArrayList<Task> tasks){
	    	this.id = id;
	    	this.name = name;
	    	this.email = email;
	    	this.employees = employees;
	    	this.tasks = tasks;
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
		
	    //static nested class => can be instantiated without having to instantiate the outer class it belongs to. (stand alone class)
		public static class ClientBuilder{
				
				private int id = -1;
			    private String name = "";
			    private String email = "";
			    private ArrayList<Employee> employees = new ArrayList<Employee>();
			    private ArrayList<Task> tasks = new ArrayList<Task>();
			    
			    public ClientBuilder(String name){
			    	this.name = name;
			    }
			    
			    public ClientBuilder id(int id){
			    	this.id = id;
			    	return this;
			    }
			    public ClientBuilder email(String email){
			    	this.email = email;
			    	return this;
			    }
			    public ClientBuilder employees(ArrayList<Employee> employees){
			    	this.employees = employees;
			    	return this;
			    }
			    public ClientBuilder tasks(ArrayList<Task> tasks){
			    	this.tasks = tasks;
			    	return this;
			    }
			    public Client createClient(){
					if(id!=-1){
						return new Client(this.id,this.name,this.email,this.employees,this.tasks);
					}
					//create new Client in DataBase
					return new Client(this.name,this.email,this.employees,this.tasks);
			    }
		}
		
}


