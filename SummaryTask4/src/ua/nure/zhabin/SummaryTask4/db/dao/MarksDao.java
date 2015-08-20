package ua.nure.zhabin.SummaryTask4.db.dao;

import java.sql.Connection;

public interface MarksDao<E> {
	
	E get(long userId, Connection connection);
	void add(E marks, Connection connection);
	void update(E marks, Connection connection);

}
