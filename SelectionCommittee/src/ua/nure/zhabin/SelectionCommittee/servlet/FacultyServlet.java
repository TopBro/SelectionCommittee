package ua.nure.zhabin.SelectionCommittee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zhabin.SelectionCommittee.db.Fields;
import ua.nure.zhabin.SelectionCommittee.db.entity.Faculty;
import ua.nure.zhabin.SelectionCommittee.service.FacultiesService;
import ua.nure.zhabin.SelectionCommittee.util.Urls;

/**
 * Servlet implementation class FacultyServlet
 */
@WebServlet("/Faculty")
public class FacultyServlet extends HttpServlet {
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
		request.getRequestDispatcher(Urls.DISPLAY_FACULTIES_SERVLET).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter(Fields.FACULTY_ID) != null) {
			long facultyId = Long.parseLong(request.getParameter(Fields.FACULTY_ID));
			Faculty faculty = facultiesService.getFaculty(facultyId);
			request.setAttribute("faculty", faculty);
			request.getRequestDispatcher(Urls.ADMIN_EDIT_FACULTY_PAGE).forward(request, response);
			return;
		}
		request.getRequestDispatcher(Urls.ADMIN_ADD_FACULTY_PAGE).forward(request, response);
	}

}
