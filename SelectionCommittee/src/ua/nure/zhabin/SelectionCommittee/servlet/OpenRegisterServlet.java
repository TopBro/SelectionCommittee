package ua.nure.zhabin.SelectionCommittee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zhabin.SelectionCommittee.db.Fields;
import ua.nure.zhabin.SelectionCommittee.service.RegistrationService;
import ua.nure.zhabin.SelectionCommittee.util.Urls;

/**
 * Servlet implementation class OpenRegisterServlet
 */
@WebServlet("/OpenRegister")
public class OpenRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RegistrationService registrationService;

	public void init() throws ServletException {
		this.registrationService = (RegistrationService) getServletContext().getAttribute("RegistrationService");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("message") != null) {
			String message = "Register has been opened";
			request.setAttribute("message", message);
		}
		request.getRequestDispatcher(Urls.DISPLAY_FACULTIES_SERVLET).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long facultyId = Long.parseLong(request.getParameter(Fields.FACULTY_ID));
		registrationService.openRegister(facultyId);
		response.sendRedirect(response.encodeRedirectURL(Urls.OPEN_REGISTER_SERVLET + "?message=true"));
	}
}
