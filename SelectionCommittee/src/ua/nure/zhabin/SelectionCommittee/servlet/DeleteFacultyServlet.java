package ua.nure.zhabin.SelectionCommittee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zhabin.SelectionCommittee.db.Fields;
import ua.nure.zhabin.SelectionCommittee.service.FacultiesService;
import ua.nure.zhabin.SelectionCommittee.util.Urls;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "Faculty deleted";
		request.setAttribute("message", message);
		request.getRequestDispatcher(Urls.DISPLAY_FACULTIES_SERVLET).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long facultyId = Long.parseLong(request.getParameter(Fields.FACULTY_ID));
		facultiesService.delete(facultyId);
		response.sendRedirect(response.encodeRedirectURL(Urls.DELETE_FACULTY_SERVLET));
	}

}
