package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exceptions.DAOException;
import models.Contact;

public class PhoneBookDAO {
	public final String hostName = "jdbc:mysql://127.0.0.1/phonebook";
	public final String userName = "yarostbaklajana";
	public final String password = "udusen81";

	public PhoneBookDAO() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	public void addContact(Contact contact) throws DAOException {
		final String insertStatement = "INSERT INTO `contacts` (`firstName`, `lastName`) VALUES (?, ?)";
		try(Connection connection = connect();) {
			System.out.println("Connected");
			PreparedStatement statement = connection.prepareStatement(insertStatement);
			statement.setString(1, contact.getFirstName());
			statement.setString(2, contact.getLastName());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Can't connect to database");
		}
		
		
	}
	

	
	public Connection connect() throws SQLException {
		
		return DriverManager.getConnection(hostName, userName, password);
	}

}