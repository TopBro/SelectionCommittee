package ua.nure.zhabin.SummaryTask4.db.dao.mysql;

import java.sql.Connection;

import ua.nure.zhabin.SummaryTask4.db.JdbcTemplate;
import ua.nure.zhabin.SummaryTask4.db.dao.UserDao;
import ua.nure.zhabin.SummaryTask4.db.entity.User;
import ua.nure.zhabin.SummaryTask4.db.mapper.UserMapper;

public class MysqlUserDao implements UserDao {
	
	private static final String GET_USER_BY_ID = "Select * from Users where id = ?";
	private static final String GET_USER_BY_LOGIN = "Select * from Users where login = ?";
	private static final String ADD_USER = "Insert into Users values(default, ?, ?, ?)";
	
	private JdbcTemplate<User> jdbcTemplate;
	
	public MysqlUserDao() {
		this.jdbcTemplate = new JdbcTemplate<>();
	}

	@Override
	public User get(long id, Connection connection) {
		return jdbcTemplate.get(connection, GET_USER_BY_ID, new Object[] {id}, new UserMapper());
	}

	@Override
	public User get(String login, Connection connection) {
		return jdbcTemplate.get(connection, GET_USER_BY_LOGIN, new Object[] {login}, new UserMapper());
	}

	@Override
	public long add(User user, Connection connection) {
		return jdbcTemplate.createUser(connection, ADD_USER, new Object[] {user.getLogin(),
				user.getPassword(), user.getRoleId()});
	}
}
