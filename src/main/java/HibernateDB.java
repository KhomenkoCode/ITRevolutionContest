package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class HibernateDB {
	
	String hostname = "ec2-46-137-117-43.eu-west-1.compute.amazonaws.com";
	String port = "5432";
	String dbname = "db7c19bjk1elks";
	String username = "tjsythqhtsktln";
	String password = "bd8494678c1a400d053e1e5f3303aaabfaef2ee0331584b169fd7aa4ec20fabf"; 
	Connection connection = null;
	
	//"jdbc:postgresql://ec2-46-137-117-43.eu-west-1.compute.amazonaws.com:5432/db7c19bjk1elks?ssl=true&sslmode=require&user=tjsythqhtsktln&password=bd8494678c1a400d053e1e5f3303aaabfaef2ee0331584b169fd7aa4ec20fabf";
	public void Connect(){
		
		if(connection != null)
			return;
		
		try {
			String URL = "jdbc:postgresql://"+hostname+":"+port+"/"+dbname + "?ssl=true&sslmode=require";
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(URL,"username", "password");
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
