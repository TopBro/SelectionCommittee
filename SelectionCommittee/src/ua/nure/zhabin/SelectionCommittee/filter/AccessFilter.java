package ua.nure.zhabin.SelectionCommittee.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import ua.nure.zhabin.SelectionCommittee.db.Fields;
import ua.nure.zhabin.SelectionCommittee.db.entity.User;
import ua.nure.zhabin.SelectionCommittee.util.Urls;

/**
 * Servlet Filter implementation class AccessFilter
 */
public class AccessFilter implements Filter {
	
	private static final Logger LOG = Logger.getLogger(AccessFilter.class);
	
	private static final String PARAM_ADMIN_DENIED_URI = "adminDeniedUri";
	private static final String PARAM_ENROLLEES_DENIED_URI = "enrolleesDeniedUri";
	private static final String PARAM_COMMONS_DENIED_URI = "commonsDeniedUri";
	private static final String ATTR_CURRENT_USER = "CurrentUser";
	private static final String ATTR_LOGIN_PAGE_MESSAGE = "loginMessage";
	private static final String WARNING_MESSAGE = "You do not have<br>permission to access<br>the requested resource";
	
	List<String> adminDeniedUri = new ArrayList<String>();
	List<String> enrolleesDeniedUri = new ArrayList<String>();
	List<String> commonsDeniedUri = new ArrayList<String>();

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		LOG.debug("Filter destruction starts");
		// do nothing
		LOG.debug("Filter destruction finished");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LOG.debug("Filter starts");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		User user = (User) httpRequest.getSession().getAttribute(ATTR_CURRENT_USER);
		String absoluteUri = httpRequest.getRequestURI();
		String uri = absoluteUri.substring(absoluteUri.lastIndexOf("/"), absoluteUri.length());
		LOG.debug("Requested uri --> " + uri);
		if (user == null) {
			if (commonsDeniedUri.contains(uri)) {
				forwardToLogin(request, response);
				return;
			}
		} else if ((user.getRoleId() == Fields.ENROLLEE_ROLE && enrolleesDeniedUri.contains(uri))
				|| (user.getRoleId() == Fields.ADMIN_ROLE && adminDeniedUri.contains(uri))) {
			forwardToLogin(request, response);
			return;
		}
		LOG.debug("Filter finished");
		chain.doFilter(request, response);		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		LOG.debug("Filter initialization starts");	
		adminDeniedUri = asList(fConfig.getInitParameter(PARAM_ADMIN_DENIED_URI));
		enrolleesDeniedUri = asList(fConfig.getInitParameter(PARAM_ENROLLEES_DENIED_URI));
		commonsDeniedUri = asList(fConfig.getInitParameter(PARAM_COMMONS_DENIED_URI));
		LOG.debug("adminDeniedUri --> " + adminDeniedUri);
		LOG.debug("enrolleesDeniedUri --> " + enrolleesDeniedUri);
		LOG.debug("commonsDeniedUri --> " + commonsDeniedUri);
		LOG.debug("Filter initialization finished");
	}
	
	private List<String> asList(String uri) {
		List<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(uri);
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		return list;
	}
	
	private void forwardToLogin(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String message = WARNING_MESSAGE;
		request.setAttribute(ATTR_LOGIN_PAGE_MESSAGE, message);
		request.getRequestDispatcher(Urls.LOGIN_PAGE).forward(request, response);
	}
}
