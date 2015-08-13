package ua.nure.zhabin.SummaryTask4.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import ua.nure.zhabin.SummaryTask4.bean.SignupBean;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlCertificateMarksDao;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlEnrolleeDao;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlUserDao;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlVnoMarksDao;
import ua.nure.zhabin.SummaryTask4.service.UserService;
import ua.nure.zhabin.SummaryTask4.validator.SignupBeanValidator;
import ua.nure.zhabin.SummaryTask4.validator.Validator;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event)  { 
    	
    	MysqlUserDao userDao = new MysqlUserDao();
    	MysqlEnrolleeDao enrolleeDao = new MysqlEnrolleeDao();
    	MysqlVnoMarksDao vnoMarksDao = new MysqlVnoMarksDao();
    	MysqlCertificateMarksDao certificateMarksDao = new MysqlCertificateMarksDao();
    	
    	UserService userService = new UserService(userDao, enrolleeDao, vnoMarksDao, certificateMarksDao);
    	
    	Validator<SignupBean> signupBeanValidator = new SignupBeanValidator();
    	
    	event.getServletContext().setAttribute("UserService", userService);
    	event.getServletContext().setAttribute("SignupBeanValidator", signupBeanValidator);
    }
    
    public void contextDestroyed(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    }
}
