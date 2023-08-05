package externalTools;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SQL_implementation {
	
	Connection mySQL_Connection;
	Statement mySQL_Statement;
	
	public SQL_implementation (String host, String dbName, String userName, String password) {
		
		try {
				mySQL_Connection = DriverManager.getConnection(("jdbc:mysql://" + host + ":3306" + '/' + dbName), userName, password);
				mySQL_Statement = mySQL_Connection.createStatement();
			}
		catch (Exception e) {
			System.out.println("There is a problem with connection to a dataBase");
		}
		
		
		
		}
	
	public HashMap<String, String> getCredentialsAsHashMap(String email) throws SQLException {
		
		HashMap<String, String> credentailsMap = new HashMap<String, String>();
		String userNameString = null;
		String userPassword = null;
		int indexKolumnyZmailami = localiseColumnIndex("email");
		int indexKolumnyZuserName = localiseColumnIndex("ernam");
		int indexKolumnyZuserPassword = localiseColumnIndex("passw");
		ResultSet resSet = mySQL_Statement.executeQuery("SELECT * FROM users");
		
		System.out.println(indexKolumnyZmailami);
		System.out.println(indexKolumnyZuserPassword);
		System.out.println(indexKolumnyZuserName);
		
		while(resSet.next()) {
			if(resSet.getString(indexKolumnyZmailami).toLowerCase().contains(email.toLowerCase())) {
				userNameString = resSet.getString(indexKolumnyZuserName);
				userPassword = resSet.getString(indexKolumnyZuserPassword);
			}
		}
		credentailsMap.put("user", userNameString);
		credentailsMap.put("password", userPassword);
		return credentailsMap;
	}
	
	
	private int localiseColumnIndex(String columnLabel) throws SQLException {
		
		int index = 1;
		ResultSet resSet = mySQL_Statement.executeQuery("DESCRIBE users");
		
		while(resSet.next()) {
			
			if(resSet.getString(1).toLowerCase().contains(columnLabel.toLowerCase())) {
				resSet.close();
				return index;
			}
			
			index++;
		}
		
		return 0;
	}


	public static void main(String... args) throws SQLException {
		SQL_implementation obj = new SQL_implementation("localhost", "fw_mws", "root", "8delfinek!8");
		System.out.println((obj.getCredentialsAsHashMap("b_bou@sth.com")).get("password"));
		System.out.println("finally on git");
	}
		
}

