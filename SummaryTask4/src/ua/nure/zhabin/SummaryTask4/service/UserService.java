package ua.nure.zhabin.SummaryTask4.service;

import java.sql.Connection;

import org.omg.PortableServer.POAManagerPackage.State;

import ua.nure.zhabin.SummaryTask4.bean.SignupBean;
import ua.nure.zhabin.SummaryTask4.db.ConnectionPool;
import ua.nure.zhabin.SummaryTask4.db.Fields;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlEnrolleeDao;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlUserDao;
import ua.nure.zhabin.SummaryTask4.db.entity.Enrollee;
import ua.nure.zhabin.SummaryTask4.db.entity.User;

public class UserService {

	private ConnectionPool pool;
	private MysqlUserDao mysqlUserDao;
	private MysqlEnrolleeDao mysqlEnrolleeDao;
	
	public UserService() {
		pool = ConnectionPool.getInstance();
		mysqlUserDao = new MysqlUserDao();
		mysqlEnrolleeDao = new MysqlEnrolleeDao();
	}
	
	public boolean isUserExist(String login) {
		Connection con = pool.getConnection();
		return mysqlUserDao.get(login, con) != null;
	}
	
	public void createUser(SignupBean signupBean) {
		Connection con = pool.getConnection();
		User user = new User();
		long userId;
		Enrollee enrollee = new Enrollee();
		user.setLogin(signupBean.getLogin());
		user.setPassword(signupBean.getPassword());
		user.setRoleId(Fields.ENROLLEE_ROLE);
		userId = mysqlUserDao.add(user, con);
		enrollee.setUserId(userId);
		enrollee.setFirstName(signupBean.getFirstName());
		enrollee.setMidleName(signupBean.getMidleName());
		enrollee.setLastName(signupBean.getLastName());
		enrollee.setEmail(signupBean.getEmail());
		enrollee.setCity(signupBean.getCity());
		enrollee.setRegion(signupBean.getRegion());
		enrollee.setEducation(signupBean.getEducation());
		enrollee.setStateId(Fields.ACTIVE_STATE);
		mysqlEnrolleeDao.add(enrollee, con);
		
	}
}
