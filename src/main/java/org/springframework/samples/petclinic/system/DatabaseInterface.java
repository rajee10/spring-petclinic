package org.springframework.samples.petclinic.system;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DatabaseInterface {
	private final String url = "jdbc:mysql://107.180.51.102/petclinic";
	private final String username = "petclinic";
	private final String password = "petclinic";

	private Connection connection;

	public DatabaseInterface() {
		try {
			this.connection = (Connection) DriverManager.getConnection(url, username, password);
			System.out.println("Database connected!");
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public Connection getConnection() { return this.connection; }
	
	public ResultSet getResults(String query) throws SQLException
	{
		Statement statement = (Statement) this.connection.createStatement();
	    return statement.executeQuery(query);
	}
}