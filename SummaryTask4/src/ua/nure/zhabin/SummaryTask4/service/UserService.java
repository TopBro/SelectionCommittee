package ua.nure.zhabin.SummaryTask4.service;

import java.sql.Connection;

import org.omg.PortableServer.POAManagerPackage.State;

import ua.nure.zhabin.SummaryTask4.bean.SignupBean;
import ua.nure.zhabin.SummaryTask4.db.ConnectionPool;
import ua.nure.zhabin.SummaryTask4.db.Fields;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlCertificateMarksDao;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlEnrolleeDao;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlUserDao;
import ua.nure.zhabin.SummaryTask4.db.dao.mysql.MysqlVnoMarksDao;
import ua.nure.zhabin.SummaryTask4.db.entity.Enrollee;
import ua.nure.zhabin.SummaryTask4.db.entity.User;
import ua.nure.zhabin.SummaryTask4.db.mapper.EnrolleeMapper;
import ua.nure.zhabin.SummaryTask4.db.mapper.UserMapper;

public class UserService {

	private ConnectionPool pool;
	private MysqlUserDao mysqlUserDao;
	private MysqlEnrolleeDao mysqlEnrolleeDao;
	private MysqlVnoMarksDao mysqlVnoMarksDao;
	private MysqlCertificateMarksDao mysqlCertificateMarksDao;
	private UserMapper userMapper;
	private EnrolleeMapper enrolleeMapper;
	
	public UserService() {
		pool = ConnectionPool.getInstance();
		mysqlUserDao = new MysqlUserDao();
		mysqlEnrolleeDao = new MysqlEnrolleeDao();
		mysqlEnrolleeDao = new MysqlEnrolleeDao();
		mysqlVnoMarksDao = new MysqlVnoMarksDao();
		mysqlCertificateMarksDao = new MysqlCertificateMarksDao();
		userMapper = new UserMapper();
		enrolleeMapper = new EnrolleeMapper();
	}
	
	public boolean isUserExist(String login) {
		Connection con = pool.getConnection();
		return mysqlUserDao.get(login, con) != null;
	}
	
	public void createUser(SignupBean signupBean) {
		Connection con = pool.getConnection();
		User user = userMapper.extract(signupBean);
		Enrollee enrollee = enrolleeMapper.extract(signupBean);
		
		long userId = mysqlUserDao.add(user, con);		
		enrollee.setUserId(userId);		
		mysqlEnrolleeDao.add(enrollee, con);
		
	}
}
