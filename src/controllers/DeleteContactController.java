package controllers;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhoneBookDAO;
import exceptions.DAOException;

@WebServlet("/DeleteContactController")
public class DeleteContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		PhoneBookDAO dao;
		ArrayList<String> errorMessages = new ArrayList<>();
		if (id != 0) {

			try {
				dao = new PhoneBookDAO();
				dao.deleteContact(id);
			} catch (DAOException e) {
				errorMessages.add(e.getMessage());
				request.setAttribute("errorMessages", errorMessages);
				response.sendRedirect("/PhoneBook");
			}
		}
		response.sendRedirect("/PhoneBook");

	}

}
