package ua.nure.zhabin.SummaryTask4.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zhabin.SummaryTask4.db.Fields;
import ua.nure.zhabin.SummaryTask4.db.entity.Faculty;
import ua.nure.zhabin.SummaryTask4.db.entity.User;
import ua.nure.zhabin.SummaryTask4.service.FacultiesService;

/**
 * Servlet implementation class DisplayFacultiesServlet
 */
@WebServlet("/DisplayFaculties")
public class DisplayFacultiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	FacultiesService facutiesService;
	
	public void init() throws ServletException {
		this.facutiesService = (FacultiesService) getServletContext().getAttribute("FacutiesService");
	}
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		displayFaculties(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		displayFaculties(request, response);
	}
	
	private void displayFaculties(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("CurrentUser");
		
		if (user == null) {
			String message = "Your session has expired.<br>Enter your login<br>and password to log in.";
			request.setAttribute("loginMessage", message);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		List<Faculty> faculties = facutiesService.getAllFaculties();
		
		request.setAttribute("faculties", faculties);
		
		if (user.getRoleId() == Fields.ADMIN_ROLE) {
			request.getRequestDispatcher("WEB-INF/AdminDisplayFacultiesPage.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("DisplayFacultiesPage.jsp").forward(request, response);
		}
	}

}
