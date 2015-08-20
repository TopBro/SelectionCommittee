package ua.nure.zhabin.SummaryTask4.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ua.nure.zhabin.SummaryTask4.bean.MarksBean;
import ua.nure.zhabin.SummaryTask4.db.entity.User;
import ua.nure.zhabin.SummaryTask4.service.MarksService;

/**
 * Servlet implementation class DisplayMarksServlet
 */
@WebServlet("/DisplayMarks")
public class DisplayMarksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MarksService marksService;
       
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		this.marksService = (MarksService) getServletContext().getAttribute("MarksService");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		displayMarks(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		displayMarks(request, response);
	}
	
	private void displayMarks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("CurrentUser");
		
		if (user == null) {
			String message = "Your session has expired.<br>Enter your login<br>and password to log in.";
			request.setAttribute("loginMessage", message);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		if (marksService.isMarksExist(user.getId())) {
			MarksBean marksBean = marksService.getMarks(user.getId());
			request.setAttribute("marksBean", marksBean);
		}
		
		request.getRequestDispatcher("MarksPage.jsp").forward(request, response);
	}
}
