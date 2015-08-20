package ua.nure.zhabin.SummaryTask4.filter;

import org.apache.log4j.Logger;

import ua.nure.zhabin.SummaryTask4.locale.SessionLocaleContainer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

public class LocaleFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(LocaleFilter.class);

    private static final String INIT_PARAM_SUPPORT_LOCALES = "SupportLocales";
    private static final String INIT_PARAM_DEFAULT_LOCALE = "DefaultLocale";
    private static final String LANGUAGE_PARAM = "lang";

    private SessionLocaleContainer localeContainer = new SessionLocaleContainer();
    private Locale defaultLocale;
    private Map<String, Locale> supportLocales;

    public void init(FilterConfig config) throws ServletException {
        initSupportLocales(config);
        this.defaultLocale = new Locale(config.getServletContext().getInitParameter(INIT_PARAM_DEFAULT_LOCALE));
    }

    private void initSupportLocales(FilterConfig config) {
        String locales = config.getServletContext().getInitParameter(INIT_PARAM_SUPPORT_LOCALES);
        supportLocales = new HashMap<>();
        for (String localeLang : locales.split(",")) {
            LOG.info("Init list of support locales " + localeLang);
            supportLocales.put(localeLang, new Locale(localeLang));
        }
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

        Locale locale = getLocale(httpServletRequest);
        localeContainer.saveLocale(httpServletRequest, httpServletResponse, locale);
        httpServletRequest.setAttribute("currentLocale", locale.getLanguage().toUpperCase());
        HttpServletRequestWrapper wrapper = wrapRequest(httpServletRequest);
        chain.doFilter(wrapper, resp);
    }

    private Locale getLocale(HttpServletRequest request) {
        Locale locale = extractLocale(request);
        if (locale != null) {
            LOG.info("Extract success! Return extracted locale!");
            return locale;
        }
        LOG.info("Return default locale!");
        return defaultLocale;
    }

    private Locale extractLocale(HttpServletRequest request) {
        String language = request.getParameter(LANGUAGE_PARAM);
        if (language != null && isLocaleSupport(language)) {
            LOG.info("Return requested locale! " + language);
            return new Locale(language);
        }
        Locale storedLocale = localeContainer.getLocale(request);
        if (storedLocale != null) {
            LOG.info("Return stored locale! " + storedLocale.getLanguage());
            return storedLocale;
        }
        return getAcceptedLocale(request);
    }

    private Locale getAcceptedLocale(HttpServletRequest request) {
        Enumeration<Locale> localeEnumeration = request.getLocales();
        while (localeEnumeration.hasMoreElements()) {
            Locale locale = localeEnumeration.nextElement();
            if (isLocaleSupport(locale.getLanguage())) {
                LOG.info("Return accepted locale! " + locale.getLanguage());
                return locale;
            }
        }
        LOG.info("No such accepted locale, return null!");
        return null;
    }

    private boolean isLocaleSupport(String localeLang) {
        return supportLocales.keySet().contains(localeLang);
    }

    private HttpServletRequestWrapper wrapRequest(final HttpServletRequest request) {
        return new HttpServletRequestWrapper(request) {
            @Override
            public Locale getLocale() {
                return localeContainer.getLocale(request);
            }

            @Override
            public Enumeration<Locale> getLocales() {
                ArrayList<Locale> locales = new ArrayList<>();
                locales.add(localeContainer.getLocale(request));
                return Collections.enumeration(locales);
            }
        };
    }

}
