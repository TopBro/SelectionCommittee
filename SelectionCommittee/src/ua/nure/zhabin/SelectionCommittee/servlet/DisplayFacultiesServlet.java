package ua.nure.zhabin.SelectionCommittee.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zhabin.SelectionCommittee.db.Fields;
import ua.nure.zhabin.SelectionCommittee.db.entity.Faculty;
import ua.nure.zhabin.SelectionCommittee.db.entity.User;
import ua.nure.zhabin.SelectionCommittee.service.FacultiesService;
import ua.nure.zhabin.SelectionCommittee.util.Urls;

/**
 * Servlet implementation class DisplayFacultiesServlet
 */
@WebServlet("/DisplayFaculties")
public class DisplayFacultiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FacultiesService facutiesService;

	public void init() throws ServletException {
		this.facutiesService = (FacultiesService) getServletContext()
				.getAttribute("FacutiesService");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		displayFaculties(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		displayFaculties(request, response);
	}

	private void displayFaculties(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("CurrentUser");
		List<Faculty> faculties = facutiesService.getAllFaculties();
		request.setAttribute("faculties", faculties);
		if (user.getRoleId() == Fields.ADMIN_ROLE) {
			request.getRequestDispatcher(Urls.ADMIN_DISPLAY_FACULTIES_PAGE).forward(request, response);
		} else {
			request.getRequestDispatcher(Urls.DISPLAY_FACULTIES_PAGE).forward(request, response);
		}
	}

}
