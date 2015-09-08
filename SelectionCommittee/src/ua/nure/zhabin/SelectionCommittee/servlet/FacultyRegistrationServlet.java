package ua.nure.zhabin.SelectionCommittee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zhabin.SelectionCommittee.service.MarksService;
import ua.nure.zhabin.SelectionCommittee.service.RegistrationService;

/**
 * Servlet implementation class FacultyRegistrationServlet
 */
@WebServlet("/FacultyRegistration")
public class FacultyRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String WARNING_PARAM = "warning";
	private static final String SUCCESS_PARAM = "success";
	private static final String BLOCKED_PARAM = "blocked";
	private static final String CLOSED_PARAM = "closed";
	private static final String MARKS_PARAM = "marks";

	RegistrationService registrationService;
	private MarksService marksService;

	public void init() throws ServletException {
		this.registrationService = (RegistrationService) getServletContext()
				.getAttribute("RegistrationService");
		this.marksService = (MarksService) getServletContext().getAttribute(
				"MarksService");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String message = "";

		if (request.getParameter("message").equals(BLOCKED_PARAM)) {
			message = "You can not apply<br> You are blocked by the administrator";
		} else if (request.getParameter("message").equals(CLOSED_PARAM)) {
			message = "Registration for this faculty already closed";
		} else if (request.getParameter("message").equals(SUCCESS_PARAM)) {
			message = "You have successfully applied";
		} else if (request.getParameter("message").equals(WARNING_PARAM)) {
			message = "You have already applied for this faculty";
		} else if (request.getParameter("message").equals(MARKS_PARAM)) {
			message = "You can not apply, while marks is not filled";
			request.setAttribute("message", message);
			request.getRequestDispatcher("DisplayMarks").forward(request,
					response);
		}

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
		long userId = Long.parseLong(request.getParameter("userId"));
		long facultyId = Long.parseLong(request.getParameter("facultyId"));

		if (registrationService.isEnrolleeBlocked(userId)) {
			response.sendRedirect(response
					.encodeRedirectURL("FacultyRegistration?message="
							+ BLOCKED_PARAM));
			return;
		}

		if (!marksService.isMarksExist(userId)) {
			response.sendRedirect(response
					.encodeRedirectURL("FacultyRegistration?message="
							+ MARKS_PARAM));
			return;
		}

		if (registrationService.isFacultyClosed(facultyId)) {
			response.sendRedirect(response
					.encodeRedirectURL("FacultyRegistration?message="
							+ CLOSED_PARAM));
			return;
		}

		if (registrationService.isRegistrationRecordExist(userId, facultyId)) {
			response.sendRedirect(response
					.encodeRedirectURL("FacultyRegistration?message="
							+ WARNING_PARAM));
			return;
		}

		registrationService.addRegistrationRecord(userId, facultyId);
		response.sendRedirect(response
				.encodeRedirectURL("FacultyRegistration?message="
						+ SUCCESS_PARAM));
	}

}
