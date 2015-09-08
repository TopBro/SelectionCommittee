package ua.nure.zhabin.SelectionCommittee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.zhabin.SelectionCommittee.bean.SignupBean;
import ua.nure.zhabin.SelectionCommittee.db.Fields;
import ua.nure.zhabin.SelectionCommittee.service.UserService;
import ua.nure.zhabin.SelectionCommittee.validator.SignupBeanValidator;
import ua.nure.zhabin.SelectionCommittee.validator.Validator;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {
	private static final Logger LOG = Logger.getLogger(SignupServlet.class);
	private static final long serialVersionUID = 1L;

	private UserService userService;
	private Validator<SignupBean> validator;

	public void init() throws ServletException {
		super.init();
		this.userService = (UserService) getServletContext().getAttribute(
				"UserService");
		this.validator = (SignupBeanValidator) getServletContext()
				.getAttribute("SignupBeanValidator");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("message");
		if (parameter != null) {
			String message = "You are signed up<br>Enter your login<br>and password to log in";
			request.setAttribute("loginMessage", message);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String message = null;
		SignupBean signupBean = fillSignupBean(request);

		if (!validator.isValid(signupBean)) {
			LOG.warn("Form data is not valid. Redirect to sign up page.");
			message = "All fields must be filled.";
			forwardToSignupPage(request, response, signupBean, message);
			return;
		}

		if (userService.isUserExist(signupBean.getLogin())) {
			LOG.warn("User already exist. Redirect to sign up page.");
			message = "User already exist. Choose another username.";
			forwardToSignupPage(request, response, signupBean, message);
			return;
		}

		if (userService.createUser(signupBean) != -1) {
			response.sendRedirect("Signup?message=true");
		} else {
			message = "Cannot create user.";
			forwardToSignupPage(request, response, signupBean, message);
		}
	}

	private void forwardToSignupPage(HttpServletRequest request,
			HttpServletResponse response, SignupBean signupBean, String message)
			throws ServletException, IOException {

		request.setAttribute("signupMessage", message);
		request.setAttribute("signupBean", signupBean);

		request.getRequestDispatcher("SignupPage.jsp").forward(request,
				response);
	}

	private SignupBean fillSignupBean(HttpServletRequest request) {
		SignupBean signupBean = new SignupBean();
		signupBean.setLogin(request.getParameter(Fields.USER_LOGIN));
		signupBean.setPassword(request.getParameter(Fields.USER_PASSWORD));
		signupBean.setFirstName(request
				.getParameter(Fields.ENROLLEE_FIRST_NAME));
		signupBean.setMidleName(request
				.getParameter(Fields.ENROLLEE_MIDDLE_NAME));
		signupBean.setLastName(request.getParameter(Fields.ENROLLEE_LAST_NAME));
		signupBean.setEmail(request.getParameter(Fields.ENROLLEE_EMAIL));
		signupBean.setCity(request.getParameter(Fields.ENROLLEE_CITY));
		signupBean.setRegion(request.getParameter(Fields.ENROLLEE_REGION));
		signupBean
				.setEducation(request.getParameter(Fields.ENROLLEE_EDUCATION));
		return signupBean;
	}
}
