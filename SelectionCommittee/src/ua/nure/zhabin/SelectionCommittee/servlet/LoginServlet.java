package ua.nure.zhabin.SelectionCommittee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.zhabin.SelectionCommittee.bean.LoginBean;
import ua.nure.zhabin.SelectionCommittee.db.Fields;
import ua.nure.zhabin.SelectionCommittee.db.entity.User;
import ua.nure.zhabin.SelectionCommittee.service.UserService;
import ua.nure.zhabin.SelectionCommittee.util.Urls;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final Logger LOG = Logger.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public void init() throws ServletException {
		super.init();
		this.userService = (UserService) getServletContext().getAttribute("UserService");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("CurrentUser");
		if (user != null) {
			if (user.getRoleId() == Fields.ADMIN_ROLE) {
				request.getRequestDispatcher(Urls.DISPLAY_FACULTIES_SERVLET).forward(request, response);
			} else {
				request.getRequestDispatcher(Urls.DISPLAY_REGISTRATIONS_SERVLET).forward(request, response);
			}
		} else {
			request.getRequestDispatcher(Urls.LOGIN_PAGE).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginBean loginBean = new LoginBean();
		loginBean.setLogin(request.getParameter(Fields.USER_LOGIN));
		loginBean.setPassword(request.getParameter(Fields.USER_PASSWORD));
		User user = userService.login(loginBean);
		if (user != null) {
			request.getSession().setAttribute("CurrentUser", user);
			response.sendRedirect(response.encodeRedirectURL(Urls.LOGIN_SERVLET));
			return;
		}
		String message = "Login or password is incorrect";
		LOG.warn(message);
		request.setAttribute("loginMessage", message);
		request.getRequestDispatcher(Urls.LOGIN_PAGE).forward(request, response);
	}
}
