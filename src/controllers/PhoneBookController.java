package controllers;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Collections;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhoneBookDAO;
import exceptions.DAOException;
import models.Contact;

public class PhoneBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PhoneBookController() {
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<String> errorMessages = new ArrayList<>();

		try {
			PhoneBookDAO dao = new PhoneBookDAO();
			ArrayList<Contact> contacts = dao.getAllContacts();
			request.setAttribute("contacts", contacts);
			
		} catch (DAOException e) {			
			errorMessages.add(e.getMessage());
			request.setAttribute("errorMessages", errorMessages);
		}

		request.getRequestDispatcher("mainpage.jsp").forward(request, response);
	}

	

}
