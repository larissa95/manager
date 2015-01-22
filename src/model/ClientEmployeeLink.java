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
	
     public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
