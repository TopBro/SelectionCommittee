package ua.nure.zhabin.SummaryTask4.servlet;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.zhabin.SummaryTask4.locale.SessionLocaleContainer;

/**
 * Servlet implementation class LocaleServlet
 */
@WebServlet("/Locale")
public class LocaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = Logger.getLogger(LocaleServlet.class);
	
	private static final String RUSSIAN_LANGUAGE = "ru";
	private static final String ENGLISH_LANGUAGE = "en";
    private static final String LANGUAGE_PARAM = "lang";
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionLocaleContainer localeContainer = new SessionLocaleContainer();
		Locale locale;
		
		if (request.getParameter(LANGUAGE_PARAM).equals(ENGLISH_LANGUAGE)) {
			locale = new Locale(ENGLISH_LANGUAGE);
			LOG.info("Created english locale.");
		} else {
			locale = new Locale(RUSSIAN_LANGUAGE);
			LOG.info("Created russian locale.");
		}
		
		localeContainer.saveLocale(request, response, locale);
		LOG.info("Locale saved in locale container.");
		response.sendRedirect(request.getHeader("referer"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
