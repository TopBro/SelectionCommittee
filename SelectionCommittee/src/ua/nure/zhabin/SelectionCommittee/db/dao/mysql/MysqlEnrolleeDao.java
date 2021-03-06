package ua.nure.zhabin.SelectionCommittee.db.dao.mysql;

import java.sql.Connection;
import java.util.List;

import ua.nure.zhabin.SelectionCommittee.db.JdbcTemplate;
import ua.nure.zhabin.SelectionCommittee.db.dao.EnrolleeDao;
import ua.nure.zhabin.SelectionCommittee.db.entity.Enrollee;
import ua.nure.zhabin.SelectionCommittee.db.mapper.EnrolleeMapper;

public class MysqlEnrolleeDao implements EnrolleeDao {

	private static final String GET_ENROLLEE = "Select * from Enrollees where user_id = ?";
	private static final String GET_ALL_ENROLLEES = "Select * from Enrollees";
	private static final String ADD_ENROLLEE = "Insert into Enrollees values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_ENROLLEE = "Update Enrollees set state_id = ? where user_id = ?";

	private JdbcTemplate<Enrollee> jdbcTemplate;

	public MysqlEnrolleeDao() {
		this.jdbcTemplate = new JdbcTemplate<>();
	}

	@Override
	public Enrollee get(long userId, Connection connection) {
		return jdbcTemplate.get(connection, GET_ENROLLEE, new Object[] {userId}, new EnrolleeMapper());
	}

	@Override
	public List<Enrollee> get(Connection connection) {
		return jdbcTemplate.getAll(connection, GET_ALL_ENROLLEES, new Object[] {}, new EnrolleeMapper());
	}

	@Override
	public void add(Enrollee enrollee, Connection connection) {
		jdbcTemplate.update(connection,	ADD_ENROLLEE, new Object[] {enrollee.getUserId(), enrollee.getFirstName(),
						enrollee.getMidleName(), enrollee.getLastName(), enrollee.getEmail(), enrollee.getCity(),
						enrollee.getRegion(), enrollee.getEducation(), enrollee.getStateId()});
	}

	@Override
	public void update(Enrollee enrollee, Connection connection) {
		jdbcTemplate.update(connection, UPDATE_ENROLLEE, new Object[] {enrollee.getStateId(), enrollee.getUserId()});
	}
}
