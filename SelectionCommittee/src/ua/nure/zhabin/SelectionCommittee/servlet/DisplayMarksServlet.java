package ua.nure.zhabin.SelectionCommittee.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zhabin.SelectionCommittee.bean.MarksBean;
import ua.nure.zhabin.SelectionCommittee.db.entity.User;
import ua.nure.zhabin.SelectionCommittee.service.MarksService;
import ua.nure.zhabin.SelectionCommittee.util.Urls;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		displayMarks(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		displayMarks(request, response);
	}

	private void displayMarks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("CurrentUser");
		if (marksService.isMarksExist(user.getId())) {
			MarksBean marksBean = marksService.getMarks(user.getId());
			request.setAttribute("marksBean", marksBean);
		}
		request.getRequestDispatcher(Urls.MARKS_PAGE).forward(request, response);
	}
}
