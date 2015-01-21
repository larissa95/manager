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
    
    //provide a many to many relationship to client here
    //provide a many to many relationship to task here


}