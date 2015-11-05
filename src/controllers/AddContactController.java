package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ErrorManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhoneBookDAO;
import exceptions.DAOException;
import models.Contact;

/**
 * Servlet implementation class AddContactController
 */
@WebServlet("/AddContactController")
public class AddContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addpage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		PhoneBookDAO dao;
		
		List<String> errorMessages = new ArrayList<>();
		
		if(firstName == null) {
			errorMessages.add("The firstName field is empty!");
		}
		
		if(lastName == null) {
			errorMessages.add("The lastName field is empty!");
		}
		
		if(!errorMessages.isEmpty()) {
			request.setAttribute("errorMessages", errorMessages);
			request.getRequestDispatcher("addpage.jsp").forward(request, response);
		}
		
		
		
		try {
			dao = new PhoneBookDAO();
			dao.addContact(new Contact(firstName, lastName));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/PhoneBook/phonebook");
		
		
	}

}
