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
import ua.nure.zhabin.SelectionCommittee.service.FacultiesService;
import ua.nure.zhabin.SelectionCommittee.util.Urls;
import ua.nure.zhabin.SelectionCommittee.validator.FacultyValidator;
import ua.nure.zhabin.SelectionCommittee.validator.Validator;

/**
 * Servlet implementation class UpdateFacultyServlet
 */
@WebServlet("/UpdateFaculty")
public class UpdateFacultyServlet extends HttpServlet {
	private static final Logger LOG = Logger.getLogger(UpdateFacultyServlet.class);
	private static final long serialVersionUID = 1L;

	FacultiesService facutiesService;
	private Validator<Faculty> validator;

	public void init() throws ServletException {
		this.facutiesService = (FacultiesService) getServletContext().getAttribute("FacutiesService");
		this.validator = (FacultyValidator) getServletContext().getAttribute("FacultyValidator");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "Faculty has been updated";
		request.setAttribute("message", message);
		request.getRequestDispatcher(Urls.DISPLAY_FACULTIES_SERVLET).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = null;
		long facultyId = Long.parseLong(request.getParameter(Fields.FACULTY_ID));
		Faculty faculty = fillFaculty(request);
		if (faculty == null) {
			faculty = new Faculty();
			if (facutiesService.isFacultyExistById(facultyId)) {
				faculty = facutiesService.getFaculty(facultyId);
			}
			LOG.warn("Forward to edit faculty page.");
			message = "All fields must be filled<br>Fields for budget and total places must contain numbers only";
			forwardToEditFacultyPage(request, response, faculty, message);
			return;
		}
		if (!validator.isValid(faculty)) {
			LOG.warn("Form data is not valid. Forward to edit faculty page.");
			message = "All fields must be filled and total places cannot be less 1";
			forwardToEditFacultyPage(request, response, faculty, message);
			return;
		}
		facutiesService.update(faculty);
		response.sendRedirect(response.encodeRedirectURL(Urls.UPDATE_FACULTY_SERVLET));
	}

	private void forwardToEditFacultyPage(HttpServletRequest request, HttpServletResponse response, Faculty faculty, String message)
			throws ServletException, IOException {
		request.setAttribute("message", message);
		request.setAttribute("faculty", faculty);
		request.getRequestDispatcher(Urls.ADMIN_EDIT_FACULTY_PAGE).forward(request, response);
	}

	private Faculty fillFaculty(HttpServletRequest request) {
		Faculty faculty = new Faculty();
		faculty.setId(Long.parseLong(request.getParameter(Fields.FACULTY_ID)));
		faculty.setName(request.getParameter(Fields.FACULTY_NAME));
		try {
			faculty.setBudget(Integer.parseInt(request.getParameter(Fields.FACULTY_BUDGET)));
			faculty.setTotal(Integer.parseInt(request.getParameter(Fields.FACULTY_TOTAL)));
		} catch (NumberFormatException e) {
			LOG.warn("Cannot parse marks data.");
			return null;
		}
		return faculty;
	}
}
