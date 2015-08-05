package ua.nure.zhabin.SummaryTask4.service;

import java.sql.Connection;

import ua.nure.zhabin.SummaryTask4.bean.SignupBean;
import ua.nure.zhabin.SummaryTask4.db.ConnectionPool;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlUserDao;

public class UserService {

	private ConnectionPool pool;
	private MysqlUserDao mysqlUserDao;
	
	public UserService() {
		pool = ConnectionPool.getInstance();
		mysqlUserDao = new MysqlUserDao();
	}
	
	public boolean isUserExist(String login) {
		Connection con = pool.getConnection();
		return mysqlUserDao.get(login, con) != null;
	}
	
	public void createUser(SignupBean signupBean) {
		
	}
}
