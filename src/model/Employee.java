package model;

import java.util.ArrayList;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

public class Employee {
   
	@DatabaseField (generatedId=true)
    private int id;
    
    @DatabaseField
	private String name;
	
    //one to many relationship to work
    @ForeignCollectionField
    ArrayList<Work> work;
    //provide a many to many relationship to task here

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

	public ArrayList<Work> getWork() {
		return work;
	}

	public void setWork(ArrayList<Work> work) {
		this.work = work;
	}


}