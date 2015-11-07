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

public class AddContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("firstName", "");
		request.setAttribute("lastName", "");
		renderAddPage(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		
		List<String> errorMessages = new ArrayList<>();

		if (firstName.equals("") || firstName == null) {
			errorMessages.add("The first name field is empty!");
		}

		if (lastName.equals("") || lastName == null) {
			errorMessages.add("The last name field is empty!");
		}

		if (!errorMessages.isEmpty()) {
			request.setAttribute("errorMessages", errorMessages);
			renderAddPage(request, response);
			return;
		}

		try {
			PhoneBookDAO dao = new PhoneBookDAO();
			dao.addContact(new Contact(firstName, lastName));
		} catch (DAOException e) {
			errorMessages.add(e.getMessage());
			request.setAttribute("errorMessages", errorMessages);
			renderAddPage(request, response);
		}

		response.sendRedirect("/PhoneBook/phonebook");

	}

	private void renderAddPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("addpage.jsp").forward(request, response);
	}

}
