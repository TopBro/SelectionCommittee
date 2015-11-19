package ua.nure.zhabin.SelectionCommittee.db.dao;

import java.sql.Connection;

import ua.nure.zhabin.SelectionCommittee.db.entity.User;

public interface UserDao {
	User get(long id, Connection connection);
	User get(String login, Connection connection);
	long add(User user, Connection connection);
}
