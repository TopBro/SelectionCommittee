package ua.nure.zhabin.SelectionCommittee.db.dao;

import java.sql.Connection;
import java.util.List;

import ua.nure.zhabin.SelectionCommittee.db.entity.Faculty;

public interface FacultyDao {

	Faculty getById(long facultyId, Connection connection);

	Faculty getByName(String name, Connection connection);

	List<Faculty> getAll(Connection connection);

	void add(Faculty faculty, Connection connection);

	void update(Faculty faculty, Connection connection);

	void delete(long facultyId, Connection connection);
}
