package ua.nure.zhabin.SummaryTask4.db.dao.mysql;

import java.sql.Connection;
import java.util.List;

import ua.nure.zhabin.SummaryTask4.db.Fields;
import ua.nure.zhabin.SummaryTask4.db.JdbcTemplate;
import ua.nure.zhabin.SummaryTask4.db.dao.RegistrationDao;
import ua.nure.zhabin.SummaryTask4.db.entity.RegistrationRecord;
import ua.nure.zhabin.SummaryTask4.db.mapper.RegistrationMapper;

public class MysqlRegistrationDao implements RegistrationDao {
	
	private static final String GET_REGISTRATIONS_BY_USERS_ID = "select f.name, s.name from faculties as f "
			+ "join registrations as r on f.id = r.faculty_id "
			+ "join statuses as s on s.id = r.status_id and r.user_id = ?";
	private static final String GET_REGISTRATIONS_BY_FACULTY_ID = "select r.user_id, r.faculty_id, e.last_name, "
			+ "e.first_name, e.middle_name, vm.ukrainian + vm.mathematics + vm.physics from registrations as r "
			+ "join enrollees as e on e.user_id = r.user_id join vno_marks as vm on vm.user_id = r.user_id and r.faculty_id = ?";
	private static final String GET_BY_USERS_ID_AND_FACULTY_ID = "Select * from Registrations where user_id = ? and faculty_id = ?";
	private static final String ADD_REGISTRATION_RECORD = "Insert into Registrations values(default, ?, ?, ?)";
	private static final String UPDATE_REGISTRATION_STATUS = "Update Registrations set status_id = ? where user_id = ? and faculty_id = ?";
	
	private JdbcTemplate<RegistrationRecord> jdbcTemplate;
	
	public MysqlRegistrationDao() {
		jdbcTemplate = new JdbcTemplate<>();
	}

	@Override
	public List<RegistrationRecord> getAllByUserId(long userId, Connection connection) {
		return jdbcTemplate.getAll(connection, GET_REGISTRATIONS_BY_USERS_ID, new Object[] {userId}, new RegistrationMapper());
	}

	@Override
	public List<RegistrationRecord> getAllByFacultyId(long facultyId, Connection connection) {
		return jdbcTemplate.getAll(connection, GET_REGISTRATIONS_BY_FACULTY_ID, new Object[] {facultyId}, new RegistrationMapper());
	}
	
	@Override
	public RegistrationRecord get(long userId, long facultyId, Connection connection) {
		return jdbcTemplate.get(connection, GET_BY_USERS_ID_AND_FACULTY_ID, new Object[] {userId, facultyId}, new RegistrationMapper());
	}

	@Override
	public void add(long userId, long facultyId, Connection connection) {
		jdbcTemplate.update(connection, ADD_REGISTRATION_RECORD, new Object[] {userId, facultyId, Fields.REGISTRATION_STATUS_WAITING});

	}

	@Override
	public void updateStatus(RegistrationRecord registrationRecord,	Connection connection) {
		jdbcTemplate.update(connection, UPDATE_REGISTRATION_STATUS, new Object[] {registrationRecord.getStatusId(),
				registrationRecord.getUserId(), registrationRecord.getFacultyId()});
		
	}
}
