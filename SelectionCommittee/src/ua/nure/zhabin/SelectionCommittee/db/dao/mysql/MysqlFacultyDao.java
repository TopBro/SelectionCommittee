package ua.nure.zhabin.SelectionCommittee.db.dao.mysql;

import java.sql.Connection;
import java.util.List;

import ua.nure.zhabin.SelectionCommittee.db.JdbcTemplate;
import ua.nure.zhabin.SelectionCommittee.db.dao.FacultyDao;
import ua.nure.zhabin.SelectionCommittee.db.entity.Faculty;
import ua.nure.zhabin.SelectionCommittee.db.mapper.FacultyMapper;

public class MysqlFacultyDao implements FacultyDao {

	private static final String GET_FACULTY_BY_ID = "Select * from Faculties where id = ?";
	private static final String GET_FACULTY_BY_NAME = "Select * from Faculties where name = ?";
	private static final String GET_ALL = "Select * from Faculties";
	private static final String ADD_FACULTY = "Insert into Faculties values(default, ?, ?, ?, ?)";
	private static final String UPDATE_FACULTY = "Update Faculties set name=?, budget=?, total=? where id=?";
	private static final String UPDATE_FACULTY_STATUS = "Update Faculties set faculty_status_id=? where id=?";
	private static final String DELETE_FACULTY = "Delete from Faculties where id=?";

	private JdbcTemplate<Faculty> jdbcTemplate;

	public MysqlFacultyDao() {
		jdbcTemplate = new JdbcTemplate<>();
	}

	@Override
	public Faculty getById(long facultyId, Connection connection) {
		return jdbcTemplate.get(connection, GET_FACULTY_BY_ID, new Object[] {facultyId}, new FacultyMapper());
	}

	@Override
	public Faculty getByName(String name, Connection connection) {
		return jdbcTemplate.get(connection, GET_FACULTY_BY_NAME, new Object[] {name}, new FacultyMapper());
	}

	@Override
	public List<Faculty> getAll(Connection connection) {
		return jdbcTemplate.getAll(connection, GET_ALL, new Object[] {}, new FacultyMapper());
	}

	@Override
	public void add(Faculty faculty, Connection connection) {
		jdbcTemplate.update(connection,	ADD_FACULTY, new Object[] {faculty.getName(), faculty.getBudget(),
						faculty.getTotal(), faculty.getFacultyStatusId()});
	}

	@Override
	public void update(Faculty faculty, Connection connection) {
		jdbcTemplate.update(connection,	UPDATE_FACULTY,	new Object[] {faculty.getName(), faculty.getBudget(),
						faculty.getTotal(), faculty.getId()});
	}
	
	@Override
	public void updateStatus(int facultyStatusId, long facultyId, Connection connection) {
		jdbcTemplate.update(connection,	UPDATE_FACULTY_STATUS,	new Object[] {facultyStatusId, facultyId});		
	}

	@Override
	public void delete(long facultyId, Connection connection) {
		jdbcTemplate.update(connection, DELETE_FACULTY,	new Object[] {facultyId});
	}
}
