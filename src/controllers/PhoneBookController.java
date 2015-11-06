package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhoneBookDAO;
import exceptions.DAOException;
import models.Contact;

public class PhoneBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PhoneBookController() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<String> errorMessages = new ArrayList<>();
		
		
		
		
		try {
			PhoneBookDAO dao = new PhoneBookDAO();
			ArrayList<Contact> contacts = dao.getAllContacts();
			Collections.sort(contacts);
			
			request.setAttribute("contacts", contacts);
			request.setAttribute("size", contacts.size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			errorMessages.add(e.getMessage());
			request.setAttribute("errorMessages", errorMessages);
			request.getRequestDispatcher("mainpage.jsp").forward(request, response);
			return;
		}			
		
		request.getRequestDispatcher("mainpage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
