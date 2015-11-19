package ua.nure.zhabin.SelectionCommittee.db.dao;

import java.sql.Connection;
import java.util.List;

import ua.nure.zhabin.SelectionCommittee.db.entity.RegistrationRecord;

public interface RegistrationDao {
	List<RegistrationRecord> getAllByUserId(long userId, Connection connection);
	RegistrationRecord get(long userId, long facultyId, Connection connection);
	void add(long userId, long facultyId, Connection connection);
	void updateStatus(int statusId, long userId, long facultyId, Connection connection);
}
