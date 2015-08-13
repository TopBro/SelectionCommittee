package ua.nure.zhabin.SummaryTask4.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.zhabin.SummaryTask4.bean.SignupBean;
import ua.nure.zhabin.SummaryTask4.db.Fields;
import ua.nure.zhabin.SummaryTask4.service.UserService;
import ua.nure.zhabin.SummaryTask4.validator.SignupBeanValidator;
import ua.nure.zhabin.SummaryTask4.validator.Validator;

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
		this.userService = (UserService) getServletContext().getAttribute("UserService");
		this.validator = (SignupBeanValidator) getServletContext().getAttribute("SignupBeanValidator");
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.userService = (UserService) config.getServletContext().getAttribute("UserService");
		this.validator = (SignupBeanValidator) config.getServletContext()
				.getAttribute("SignupBeanValidator");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = null;
		SignupBean signupBean = new SignupBean();
		signupBean.setLogin(request.getParameter(Fields.USER_LOGIN));
		signupBean.setPassword(request.getParameter(Fields.USER_PASSWORD));
		signupBean.setFirstName(request.getParameter(Fields.ENROLLEE_FIRST_NAME));
		signupBean.setMidleName(request.getParameter(Fields.ENROLLEE_MIDDLE_NAME));
		signupBean.setLastName(request.getParameter(Fields.ENROLLEE_LAST_NAME));
		signupBean.setEmail(request.getParameter(Fields.ENROLLEE_EMAIL));
		signupBean.setCity(request.getParameter(Fields.ENROLLEE_CITY));
		signupBean.setRegion(request.getParameter(Fields.ENROLLEE_REGION));
		signupBean.setEducation(request.getParameter(Fields.ENROLLEE_EDUCATION));
		try {
			signupBean.setUkrainian(Integer.valueOf(request.getParameter(Fields.UKRAINIAN)));
			signupBean.setMathematics(Integer.valueOf(request.getParameter(Fields.MATHEMATICS)));
			signupBean.setPhysics(Integer.valueOf(request.getParameter(Fields.PHYSICS)));
			signupBean.setLiterature(Integer.valueOf(request.getParameter(Fields.LITERATURE)));
			signupBean.setHistory(Integer.valueOf(request.getParameter(Fields.HISTORY)));
			signupBean.setEnglish(Integer.valueOf(request.getParameter(Fields.ENGLISH)));
			signupBean.setInformatics(Integer.valueOf(request.getParameter(Fields.INFORMATICS)));
			signupBean.setGeography(Integer.valueOf(request.getParameter(Fields.GEOGRAPHY)));
			signupBean.setBiology(Integer.valueOf(request.getParameter(Fields.BIOLOGY )));
			signupBean.setChemistry(Integer.valueOf(request.getParameter(Fields.CHEMISTRY)));
		} catch (NumberFormatException e) {
			LOG.warn("Subject data is not valid. Redirect to sign up page.");
			message = "Fields for marks may contain numbers only.";
			redirectToSignupPage(request, response, signupBean, message);
			return;
		}
		
		if (!validator.isValid(signupBean)) {
			LOG.warn("Form data is not valid. Redirect to sign up page.");
			message = "All fields must be filled.";
			redirectToSignupPage(request, response, signupBean, message);
			return;
		}
		
		if (userService.isUserExist(signupBean.getLogin())) {
			LOG.warn("User already exist. Redirect to sign up page.");
			message = "User already exist. Choose another username.";
			redirectToSignupPage(request, response, signupBean, message);
			return;
		}
		
		userService.createUser(signupBean);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/test.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

	private void redirectToSignupPage(HttpServletRequest request, HttpServletResponse response,
			SignupBean signupBean, String message) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		session.setAttribute("signupBean", signupBean);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SignupPage.jsp");
		dispatcher.forward(request, response);
	}
}
