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
 * Servlet implementation class CloseRegisterServlet
 */
@WebServlet("/CloseRegister")
public class CloseRegisterServlet extends HttpServlet {
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
			String message = "Register has been closed";
			request.setAttribute("message", message);
		}
		request.getRequestDispatcher(Urls.DISPLAY_FACULTIES_SERVLET).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long facultyId = Long.parseLong(request.getParameter(Fields.FACULTY_ID));
		if (registrationService.isFacultyClosed(facultyId)) {
			request.setAttribute("faculty_id", facultyId);
			request.getRequestDispatcher(Urls.CLOSED_FACULTY_PAGE).forward(request, response);
		} else {
			registrationService.closeRegister(facultyId);
			response.sendRedirect(response.encodeRedirectURL(Urls.CLOSE_REGISTER_SERVLET + "?message=true"));
		}
	}

}
