package ua.nure.zhabin.SummaryTask4.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import ua.nure.zhabin.SummaryTask4.bean.LoginBean;
import ua.nure.zhabin.SummaryTask4.bean.SignupBean;
import ua.nure.zhabin.SummaryTask4.db.DbManager;
import ua.nure.zhabin.SummaryTask4.db.dao.EnrolleeDao;
import ua.nure.zhabin.SummaryTask4.db.dao.UserDao;
import ua.nure.zhabin.SummaryTask4.db.entity.Enrollee;
import ua.nure.zhabin.SummaryTask4.db.entity.User;
import ua.nure.zhabin.SummaryTask4.exception.MysqlRepositoryException;
import ua.nure.zhabin.SummaryTask4.util.SignupBeanExtractor;

public class UserService {
	
	private static final Logger LOG = Logger.getLogger(UserService.class);

	private UserDao userDao;
	private EnrolleeDao enrolleeDao;
	
	public UserService(UserDao userDao, EnrolleeDao enrolleeDao) {
		this.userDao = userDao;
		this.enrolleeDao = enrolleeDao;
	}
	
	public boolean isUserExist(String login) {
		Connection con = DbManager.getConnection();
		return userDao.get(login, con) != null;
	}
	
	public long createUser(SignupBean signupBean) {
		Connection con = DbManager.getConnection();
		long userId;
		try {
			User user = SignupBeanExtractor.extractUser(signupBean);
			Enrollee enrollee = SignupBeanExtractor.extractEnrollee(signupBean);
			userId = userDao.add(user, con);		
			enrollee.setUserId(userId);
			enrolleeDao.add(enrollee, con);
			con.commit();
		} catch (SQLException | MysqlRepositoryException e) {
			LOG.error("Cannot create user. Execute rollback.", e);;
			DbManager.rollback(con);
			return -1; 
		} finally {			
			DbManager.close(con);
		}	
		return userId;
	}
	
	public User login(LoginBean loginBean) {
		Connection con = DbManager.getConnection();
		String login = loginBean.getLogin();
		if (!isUserExist(login)) {
			return null;
		}
		User user = userDao.get(login, con);
		if (!user.getPassword().equals(loginBean.getPassword())) {
			return null;
		}
		return user;
	}
}
