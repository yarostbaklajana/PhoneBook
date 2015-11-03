package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Statement;

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
		try (Connection connection = connect();) {
			System.out.println("Connected");
			PreparedStatement statement = connection.prepareStatement(insertStatement);
			statement.setString(1, contact.getFirstName());
			statement.setString(2, contact.getLastName());
			statement.execute();
		} catch (SQLException e) {
			throw new DAOException("Unable to save contact");
		}

	}

	public ArrayList<Contact> getAllContacts() throws DAOException{
		ArrayList<Contact> contacts = new ArrayList<>();
		final String selectAllQuery = "SELECT * FROM `contacts`;";

		try (Connection connection = connect()) {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(selectAllQuery);

			while (result.next()) {
				Contact contact = new Contact();
				contact.setFirstName(result.getString("firstName"));
				contact.setLastName(result.getString("lastName"));
				contacts.add(contact);
			}

			return contacts;

		} catch (SQLException e) {			
			throw new DAOException("Unable to load list of contacts");
		}
	}
	
	public void deleteContact(int id) throws DAOException {
		final String deleteStatement = "DELETE FROM `contacts` WHERE `id`=" + id + ";";
		
		try(Connection connection = connect();) {
			Statement statement = connection.createStatement();
			statement.executeUpdate(deleteStatement);
			
		} catch (SQLException e) {
			throw new DAOException("Unable to delete contact");
		}
		
	}

	public Connection connect() throws SQLException {

		return DriverManager.getConnection(hostName, userName, password);
	}

}