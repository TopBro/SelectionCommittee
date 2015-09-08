package ua.nure.zhabin.SelectionCommittee.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.zhabin.SelectionCommittee.bean.MarksBean;
import ua.nure.zhabin.SelectionCommittee.db.Fields;
import ua.nure.zhabin.SelectionCommittee.db.entity.User;
import ua.nure.zhabin.SelectionCommittee.service.MarksService;
import ua.nure.zhabin.SelectionCommittee.validator.MarksBeanValidator;
import ua.nure.zhabin.SelectionCommittee.validator.Validator;

/**
 * Servlet implementation class MarksServlet
 */
@WebServlet("/Marks")
public class MarksServlet extends HttpServlet {
	private static final Logger LOG = Logger.getLogger(MarksServlet.class);
	private static final long serialVersionUID = 1L;

	private MarksService marksService;
	private Validator<MarksBean> validator;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		this.marksService = (MarksService) getServletContext().getAttribute(
				"MarksService");
		this.validator = (MarksBeanValidator) getServletContext().getAttribute(
				"MarksBeanValidator");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("message");
		if (parameter != null) {
			String message = "Marks have been submited";
			request.setAttribute("message", message);
		}
		request.getRequestDispatcher("DisplayMarks").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String message = null;
		User user = (User) request.getSession().getAttribute("CurrentUser");

		if (user == null) {
			message = "Your session has expired.<br>Enter your login<br>and password to log in.";
			request.setAttribute("loginMessage", message);
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
			return;
		}

		MarksBean marksBean = fillMarksBean(request);

		if (marksBean == null) {
			marksBean = new MarksBean();
			if (marksService.isMarksExist(user.getId())) {
				marksBean = marksService.getMarks(user.getId());
			}
			LOG.warn("Forward to marks page.");
			message = "All fields must be filled.<br>"
					+ "Fields for marks may contain numbers only.";
			forwardToMarksPage(request, response, marksBean, message);
			return;
		}

		if (!validator.isValid(marksBean)) {
			LOG.warn("Form data is not valid. Forward to marks page.");
			message = "External independent testing marks may be only from 100 to 200.<br>"
					+ "And certificate marks may be only from 1 to 12.";
			forwardToMarksPage(request, response, marksBean, message);
			return;
		}

		if (marksService.isMarksExist(user.getId())) {
			marksService.updateMarks(user.getId(), marksBean);
			response.sendRedirect(response
					.encodeRedirectURL("Marks?message=true"));
			return;
		}

		marksService.submitMarks(user.getId(), marksBean);
		response.sendRedirect(response.encodeRedirectURL("Marks?message=true"));
		return;

	}

	private void forwardToMarksPage(HttpServletRequest request,
			HttpServletResponse response, MarksBean marksBean, String message)
			throws ServletException, IOException {

		request.setAttribute("message", message);
		request.setAttribute("marksBean", marksBean);

		request.getRequestDispatcher("MarksPage.jsp")
				.forward(request, response);
	}

	private MarksBean fillMarksBean(HttpServletRequest request) {
		MarksBean marksBean = new MarksBean();
		try {
			marksBean.setUkrainian(Integer.parseInt(request
					.getParameter(Fields.UKRAINIAN)));
			marksBean.setMathematics(Integer.parseInt(request
					.getParameter(Fields.MATHEMATICS)));
			marksBean.setPhysics(Integer.parseInt(request
					.getParameter(Fields.PHYSICS)));
			marksBean.setLiterature(Integer.parseInt(request
					.getParameter(Fields.LITERATURE)));
			marksBean.setHistory(Integer.parseInt(request
					.getParameter(Fields.HISTORY)));
			marksBean.setEnglish(Integer.parseInt(request
					.getParameter(Fields.ENGLISH)));
			marksBean.setInformatics(Integer.parseInt(request
					.getParameter(Fields.INFORMATICS)));
			marksBean.setGeography(Integer.parseInt(request
					.getParameter(Fields.GEOGRAPHY)));
			marksBean.setBiology(Integer.parseInt(request
					.getParameter(Fields.BIOLOGY)));
			marksBean.setChemistry(Integer.parseInt(request
					.getParameter(Fields.CHEMISTRY)));
		} catch (NumberFormatException e) {
			LOG.warn("Cannot parse marks data.");
			return null;
		}
		return marksBean;
	}

}
