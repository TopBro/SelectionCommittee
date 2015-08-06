package ua.nure.zhabin.SummaryTask4.db.dao;

import java.sql.Connection;

import ua.nure.zhabin.SummaryTask4.db.entity.User;

public interface UserDao {

	User get(int id, Connection connection);
	User get(String login, Connection connection);
	long add(User user, Connection connection);	
}
