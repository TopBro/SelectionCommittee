package ua.nure.zhabin.SummaryTask4.db.dao;

import java.sql.Connection;

import ua.nure.zhabin.SummaryTask4.db.JdbcTemplate;
import ua.nure.zhabin.SummaryTask4.db.entity.User;
import ua.nure.zhabin.SummaryTask4.db.extractor.UserExtractor;

public class MysqlUserDao implements UserDao {
	
	private static final String GET_USER_BY_ID = "Select * from Users where id = ?";
	private static final String GET_USER_BY_LOGIN = "Select * from Users where login = ?";
	private static final String ADD_USER = "Insert into Users values(default, ?, ?, ?)";
	
	private JdbcTemplate<User> dbTemplate;
	
	public MysqlUserDao() {
		dbTemplate = new JdbcTemplate<>();
	}

	@Override
	public User get(int id, Connection connection) {
		return dbTemplate.get(connection, GET_USER_BY_ID, new Object[] {id}, new UserExtractor());
	}

	@Override
	public User get(String login, Connection connection) {
		return dbTemplate.get(connection, GET_USER_BY_ID, new Object[] {login}, new UserExtractor());
	}

	@Override
	public void add(User user, Connection connection) {
		dbTemplate.add(connection, ADD_USER, new Object[] {user.getId(), user.getLogin(),
				user.getPassword(), user.getRoleId()});
	}
}
