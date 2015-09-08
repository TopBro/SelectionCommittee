package ua.nure.zhabin.SelectionCommittee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.zhabin.SelectionCommittee.db.Fields;
import ua.nure.zhabin.SelectionCommittee.db.entity.Faculty;
import ua.nure.zhabin.SelectionCommittee.db.entity.User;
import ua.nure.zhabin.SelectionCommittee.service.FacultiesService;
import ua.nure.zhabin.SelectionCommittee.validator.FacultyValidator;
import ua.nure.zhabin.SelectionCommittee.validator.Validator;

/**
 * Servlet implementation class AddFacultyServlet
 */
@WebServlet("/AddFaculty")
public class AddFacultyServlet extends HttpServlet {
	private static final Logger LOG = Logger.getLogger(AddFacultyServlet.class);
	private static final long serialVersionUID = 1L;

	FacultiesService facutiesService;
	private Validator<Faculty> validator;

	public void init() throws ServletException {
		this.facutiesService = (FacultiesService) getServletContext()
				.getAttribute("FacutiesService");
		this.validator = (FacultyValidator) getServletContext().getAttribute(
				"FacultyValidator");
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

		message = "Faculty has been added";
		request.setAttribute("message", message);
		request.getRequestDispatcher("DisplayFaculties").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String message = null;

		Faculty faculty = fillFaculty(request);

		if (faculty == null) {
			faculty = new Faculty();
			LOG.warn("Forward to add faculty page.");
			message = "All fields must be filled<br>"
					+ "Fields for budget and total places must contain numbers only";
			forwardToAddFacultyPage(request, response, faculty, message);
			return;
		}

		if (!validator.isValid(faculty)) {
			LOG.warn("Form data is not valid. Forward to edit faculty page.");
			message = "All fields must be filled and total places cannot be less 1";
			forwardToAddFacultyPage(request, response, faculty, message);
			return;
		}

		if (facutiesService.isFacultyExistByName(faculty.getName())) {
			LOG.warn("Faculty already exist. Forward to edit faculty page.");
			message = "Faculty already exist";
			forwardToAddFacultyPage(request, response, faculty, message);
			return;
		}

		facutiesService.add(faculty);
		response.sendRedirect(response.encodeRedirectURL("AddFaculty"));
	}

	private void forwardToAddFacultyPage(HttpServletRequest request,
			HttpServletResponse response, Faculty faculty, String message)
			throws ServletException, IOException {

		request.setAttribute("message", message);
		request.setAttribute("faculty", faculty);

		request.getRequestDispatcher("WEB-INF/AdminAddFacultyPage.jsp")
				.forward(request, response);

	}

	private Faculty fillFaculty(HttpServletRequest request) {
		Faculty faculty = new Faculty();
		faculty.setName(request.getParameter(Fields.FACULTY_NAME));
		try {
			faculty.setBudget(Integer.parseInt(request
					.getParameter(Fields.FACULTY_BUDGET)));
			faculty.setTotal(Integer.parseInt(request
					.getParameter(Fields.FACULTY_TOTAL)));
		} catch (NumberFormatException e) {
			LOG.warn("Cannot parse marks data.");
			return null;
		}
		return faculty;
	}

}
