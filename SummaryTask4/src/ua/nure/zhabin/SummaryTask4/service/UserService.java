package ua.nure.zhabin.SummaryTask4.service;

import java.sql.Connection;

import ua.nure.zhabin.SummaryTask4.bean.SignupBean;
import ua.nure.zhabin.SummaryTask4.db.ConnectionPool;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlEnrolleeDao;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlUserDao;
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
		User user = new User();
		user.setLogin(signupBean.getLogin());
		user.setPassword(signupBean.getPassword());
		user.setRoleId(roleId);
	}
}
