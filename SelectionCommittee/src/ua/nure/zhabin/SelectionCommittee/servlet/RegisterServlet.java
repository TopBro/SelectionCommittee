package ua.nure.zhabin.SelectionCommittee.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zhabin.SelectionCommittee.bean.RegisterRecordBean;
import ua.nure.zhabin.SelectionCommittee.db.Fields;
import ua.nure.zhabin.SelectionCommittee.service.RegistrationService;
import ua.nure.zhabin.SelectionCommittee.util.Urls;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RegistrationService registrationService;

	public void init() throws ServletException {
		this.registrationService = (RegistrationService) getServletContext().getAttribute("RegistrationService");
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
		long facultyId = Long.parseLong(request.getParameter(Fields.FACULTY_ID));
		List<RegisterRecordBean> list = registrationService.getAllByFacultyId(facultyId);
		request.setAttribute("list", list);
		request.getRequestDispatcher(Urls.ADMIN_REGISTER_PAGE).forward(request, response);
	}
}
