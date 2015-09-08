package ua.nure.zhabin.SelectionCommittee.db.dao;

import java.sql.Connection;
import java.util.List;

import ua.nure.zhabin.SelectionCommittee.db.entity.Enrollee;

public interface EnrolleeDao {

	Enrollee get(long userId, Connection connection);

	List<Enrollee> get(Connection connection);

	void add(Enrollee enrollee, Connection connection);

	void update(Enrollee enrollee, Connection connection);

}
