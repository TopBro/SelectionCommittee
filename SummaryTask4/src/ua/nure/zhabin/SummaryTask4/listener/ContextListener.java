package ua.nure.zhabin.SummaryTask4.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ua.nure.zhabin.SummaryTask4.bean.MarksBean;
import ua.nure.zhabin.SummaryTask4.bean.SignupBean;
import ua.nure.zhabin.SummaryTask4.db.dao.EnrolleeDao;
import ua.nure.zhabin.SummaryTask4.db.dao.FacultyDao;
import ua.nure.zhabin.SummaryTask4.db.dao.MarksDao;
import ua.nure.zhabin.SummaryTask4.db.dao.RegistrationDao;
import ua.nure.zhabin.SummaryTask4.db.dao.UserDao;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlCertificateMarksDao;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlEnrolleeDao;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlFacultyDao;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlRegistrationDao;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlUserDao;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlVnoMarksDao;
import ua.nure.zhabin.SummaryTask4.db.entity.CertificateMarks;
import ua.nure.zhabin.SummaryTask4.db.entity.Faculty;
import ua.nure.zhabin.SummaryTask4.db.entity.VnoMarks;
import ua.nure.zhabin.SummaryTask4.service.FacultiesService;
import ua.nure.zhabin.SummaryTask4.service.MarksService;
import ua.nure.zhabin.SummaryTask4.service.RegistrationService;
import ua.nure.zhabin.SummaryTask4.service.UserService;
import ua.nure.zhabin.SummaryTask4.validator.FacultyValidator;
import ua.nure.zhabin.SummaryTask4.validator.MarksBeanValidator;
import ua.nure.zhabin.SummaryTask4.validator.SignupBeanValidator;
import ua.nure.zhabin.SummaryTask4.validator.Validator;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
public class ContextListener implements ServletContextListener {
	
	private static final Logger LOG = Logger.getLogger(ContextListener.class);
	
    public void contextInitialized(ServletContextEvent event)  { 
    	
    	log("Servlet context initialization starts");
    	
    	initLog4J(event.getServletContext());
    	
    	UserDao userDao = new MysqlUserDao();
    	EnrolleeDao enrolleeDao = new MysqlEnrolleeDao();
    	MarksDao<VnoMarks> vnoMarksDao = new MysqlVnoMarksDao();
    	MarksDao<CertificateMarks> certificateMarksDao = new MysqlCertificateMarksDao();
    	RegistrationDao registrationDao = new MysqlRegistrationDao();
    	FacultyDao facultyDao = new MysqlFacultyDao();
    	
    	UserService userService = new UserService(userDao, enrolleeDao);
    	MarksService marksService = new MarksService(vnoMarksDao, certificateMarksDao);
    	RegistrationService registrationService = new RegistrationService(registrationDao, enrolleeDao, facultyDao);
    	FacultiesService facutiesService = new FacultiesService(facultyDao);
    	
    	Validator<SignupBean> signupBeanValidator = new SignupBeanValidator();
    	Validator<MarksBean> marksBeanValidator = new MarksBeanValidator();
    	Validator<Faculty> facultyValidator = new FacultyValidator();
    	
    	event.getServletContext().setAttribute("UserService", userService);
    	event.getServletContext().setAttribute("MarksService", marksService);
    	event.getServletContext().setAttribute("RegistrationService", registrationService);
    	event.getServletContext().setAttribute("FacutiesService", facutiesService);
    	event.getServletContext().setAttribute("SignupBeanValidator", signupBeanValidator);
    	event.getServletContext().setAttribute("MarksBeanValidator", marksBeanValidator);
    	event.getServletContext().setAttribute("FacultyValidator", facultyValidator);
    	
    	log("Servlet context initialization finished");
    }
    
    public void contextDestroyed(ServletContextEvent event)  { 
    	log("Servlet context destruction starts");
		// do nothing
		log("Servlet context destruction finished");
    }
    
    /**
	 * Initializes log4j framework.
	 * 
	 * @param servletContext
	 */
	private void initLog4J(ServletContext servletContext) {
		log("Log4J initialization started");
		try {
			PropertyConfigurator.configure(servletContext.getRealPath(
							"WEB-INF/log4j.properties"));
		} catch (Exception ex) {
			LOG.error("Cannot configure Log4j", ex);			
		}		
		log("Log4J initialization finished");
		LOG.debug("Log4j has been initialized");
	}
	
	private void log(String msg) {
		System.out.println("[ContextListener] " + msg);
	}
}
