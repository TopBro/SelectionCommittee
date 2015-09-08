package ua.nure.zhabin.SelectionCommittee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zhabin.SelectionCommittee.db.Fields;
import ua.nure.zhabin.SelectionCommittee.db.entity.Faculty;
import ua.nure.zhabin.SelectionCommittee.db.entity.User;
import ua.nure.zhabin.SelectionCommittee.service.FacultiesService;

/**
 * Servlet implementation class FacultyServlet
 */
@WebServlet("/Faculty")
public class FacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FacultiesService facultiesService;

	public void init() throws ServletException {
		this.facultiesService = (FacultiesService) getServletContext()
				.getAttribute("FacutiesService");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("CurrentUser");
		String message;

		if (user == null || user.getRoleId() != Fields.ADMIN_ROLE) {
			message = "Your session has expired.<br>Enter your login<br>and password to log in.";
			request.setAttribute("loginMessage", message);
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
			return;
		}

		request.getRequestDispatcher("DisplayFaculties").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter(Fields.FACULTY_ID) != null) {
			long facultyId = Long.parseLong(request
					.getParameter(Fields.FACULTY_ID));
			Faculty faculty = facultiesService.getFaculty(facultyId);
			request.setAttribute("faculty", faculty);
			request.getRequestDispatcher("WEB-INF/AdminEditFacultyPage.jsp")
					.forward(request, response);
			return;
		}

		request.getRequestDispatcher("WEB-INF/AdminAddFacultyPage.jsp")
				.forward(request, response);
	}

}
