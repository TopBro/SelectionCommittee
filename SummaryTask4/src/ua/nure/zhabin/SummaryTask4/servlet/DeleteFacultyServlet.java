package ua.nure.zhabin.SummaryTask4.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zhabin.SummaryTask4.db.Fields;
import ua.nure.zhabin.SummaryTask4.db.entity.User;
import ua.nure.zhabin.SummaryTask4.service.FacultiesService;

/**
 * Servlet implementation class DeleteFacultyServlet
 */
@WebServlet("/DeleteFaculty")
public class DeleteFacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
FacultiesService facultiesService;
	
	public void init() throws ServletException {
		this.facultiesService = (FacultiesService) getServletContext().getAttribute("FacutiesService");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("CurrentUser");
		String message;
		
		if (user == null || user.getRoleId() != Fields.ADMIN_ROLE) {
			message = "Your session has expired.<br>Enter your login<br>and password to log in.";
			request.setAttribute("loginMessage", message);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		message = "Faculty deleted";
		request.setAttribute("message", message);
		request.getRequestDispatcher("DisplayFaculties").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long facultyId = Long.parseLong(request.getParameter(Fields.FACULTY_ID));
		
		facultiesService.delete(facultyId);
		
		response.sendRedirect(response.encodeRedirectURL("DeleteFaculty"));
	}

}
