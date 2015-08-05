package ua.nure.zhabin.SummaryTask4.db.dao;

import java.sql.Connection;
import java.util.List;

import ua.nure.zhabin.SummaryTask4.db.entity.Enrollee;

public interface EnrolleeDao {
	
	List<Enrollee> get(Connection connection);
	void add(Enrollee enrollee, Connection connection);
	void update(Enrollee enrollee, Connection connection);

}