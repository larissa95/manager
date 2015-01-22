import java.util.ArrayList;

import model.Client;
import model.ClientEmployeeLink;
import model.Employee;
import model.Task;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   String databaseUrl = "jdbc:h2:~/testMapper";
	        // create a connection source to our database
	        ConnectionSource connectionSource;
			try {
				connectionSource = new JdbcConnectionSource(databaseUrl);
		        TableUtils.createTableIfNotExists(connectionSource, Client.class);
		        TableUtils.createTableIfNotExists(connectionSource, ClientEmployeeLink.class);
		        TableUtils.createTableIfNotExists(connectionSource, Employee.class);
		        
		        Dao<Client, String> clientDao =
			            DaoManager.createDao(connectionSource, Client.class);
		        Client client = new Client();
		        client.setName("HI");
		        client.setEmail("test@gmx.de");
		      //  client.setTasks(new ArrayList<Task>());
		        clientDao.create(client);

			}catch(Exception e){
				e.printStackTrace();
			}
	}

}
