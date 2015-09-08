package ua.nure.zhabin.SelectionCommittee.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zhabin.SelectionCommittee.db.entity.RegistrationRecord;
import ua.nure.zhabin.SelectionCommittee.db.entity.User;
import ua.nure.zhabin.SelectionCommittee.service.RegistrationService;

/**
 * Servlet implementation class DisplayRegistrationsServlet
 */
@WebServlet("/DisplayRegistrations")
public class DisplayRegistrationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RegistrationService registrationService;

	public void init() throws ServletException {
		this.registrationService = (RegistrationService) getServletContext()
				.getAttribute("RegistrationService");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("CurrentUser");

		if (user == null) {
			String message = "Your session has expired.<br>Enter your login<br>and password to log in.";
			request.setAttribute("loginMessage", message);
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
			return;
		}

		List<RegistrationRecord> registrations = registrationService
				.getAllByUserId(user.getId());

		if (registrations.size() == 0) {
			String message = "You did not make any registrations";
			request.setAttribute("message", message);
			request.getRequestDispatcher("DisplayRegistrationsPage.jsp")
					.forward(request, response);
			return;
		}

		request.setAttribute("registrations", registrations);
		request.getRequestDispatcher("DisplayRegistrationsPage.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
