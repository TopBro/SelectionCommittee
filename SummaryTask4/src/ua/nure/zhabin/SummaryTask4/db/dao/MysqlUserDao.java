package ua.nure.zhabin.SummaryTask4.db.dao;

import java.sql.Connection;

import ua.nure.zhabin.SummaryTask4.db.DbTemplate;
import ua.nure.zhabin.SummaryTask4.db.entity.User;

public class MysqlUserDao implements UserDao {
	
	private static final String GET_USER_BY_ID = "Select * from Users where id = ?";
	private static final String GET_USER_BY_LOGIN = "Select * from Users where login = ?";
	private static final String ADD_USER = "Insert into Users values(default, ?, ?, ?)";
	
	private DbTemplate<User> dbTemplate;
	
	public MysqlUserDao() {
		dbTemplate = new DbTemplate<>();
	}

	@Override
	public User get(int id, Connection connection) {
		return dbTemplate.get(connection, GET_USER_BY_ID, extractor, id);
	}

	@Override
	public User get(String login, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(User user, Connection connection) {
		// TODO Auto-generated method stub

	}

}
