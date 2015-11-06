package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("firstName", "");
		request.setAttribute("lastName", "");
		request.getRequestDispatcher("addpage.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		
		PhoneBookDAO dao;

		List<String> errorMessages = new ArrayList<>();

		if (firstName.equals("") || firstName == null) {
			errorMessages.add("The first name field is empty!");
		}

		if (lastName.equals("") || lastName == null) {
			errorMessages.add("The last name field is empty!");
		}

		if (!errorMessages.isEmpty()) {
			request.setAttribute("errorMessages", errorMessages);
			request.getRequestDispatcher("addpage.jsp").forward(request, response);
			return;
		}

		try {
			dao = new PhoneBookDAO();
			dao.addContact(new Contact(firstName, lastName));
		} catch (DAOException e) {
			errorMessages.add(e.getMessage());
			request.setAttribute("errorMessages", errorMessages);
			request.getRequestDispatcher("addpage.jsp").forward(request, response);
		}

		response.sendRedirect("/PhoneBook/phonebook");

	}

}
