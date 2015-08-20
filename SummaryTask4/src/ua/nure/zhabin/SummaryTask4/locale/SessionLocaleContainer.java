package ua.nure.zhabin.SummaryTask4.locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Locale;

public class SessionLocaleContainer {
	
	protected static final String LOCALE = "Locale";

    public Locale getLocale(HttpServletRequest request) {
        return (Locale) request.getSession().getAttribute(LOCALE);
    }

    public void saveLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        request.getSession().setAttribute(LOCALE, locale);
    }
}
