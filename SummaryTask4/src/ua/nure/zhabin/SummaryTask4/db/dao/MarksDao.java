package ua.nure.zhabin.SummaryTask4.db.dao;

import java.sql.Connection;

public interface MarksDao<E> {
	
	void add(E marks, Connection connection);

}
