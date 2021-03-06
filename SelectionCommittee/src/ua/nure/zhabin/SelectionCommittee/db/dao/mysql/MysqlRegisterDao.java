package ua.nure.zhabin.SelectionCommittee.db.dao.mysql;

import java.sql.Connection;
import java.util.List;

import ua.nure.zhabin.SelectionCommittee.bean.RegisterRecordBean;
import ua.nure.zhabin.SelectionCommittee.db.JdbcTemplate;
import ua.nure.zhabin.SelectionCommittee.db.dao.RegisterDao;
import ua.nure.zhabin.SelectionCommittee.db.mapper.RegisterRecordMapper;

public class MysqlRegisterDao implements RegisterDao {

	private static final String GET_ACTIVE_ENROLLEES_BY_FACULTY_ID = "select r.user_id, r.faculty_id, e.last_name, e.first_name, "
			+ "e.middle_name, vm.ukrainian + vm.mathematics + vm.physics from registrations as r join enrollees as e on e.user_id "
			+ "= r.user_id join vno_marks as vm on vm.user_id = r.user_id and e.state_id = 1 and r.faculty_id = ? "
			+ "ORDER BY vm.ukrainian + vm.mathematics + vm.physics DESC";
	private static final String GET_REGISTRATIONS_BY_FACULTY_ID = "select r.user_id, r.faculty_id, e.last_name, e.first_name, "
			+ "e.middle_name, vm.ukrainian + vm.mathematics + vm.physics from registrations as r join enrollees as e on e.user_id "
			+ "= r.user_id join vno_marks as vm on vm.user_id = r.user_id and r.faculty_id = ? "
			+ "ORDER BY vm.ukrainian + vm.mathematics + vm.physics DESC";

	private JdbcTemplate<RegisterRecordBean> jdbcTemplate;

	public MysqlRegisterDao() {
		jdbcTemplate = new JdbcTemplate<>();
	}

	@Override
	public List<RegisterRecordBean> getActiveByFacultyId(long facultyId, Connection connection) {
		return jdbcTemplate.getAll(connection, GET_ACTIVE_ENROLLEES_BY_FACULTY_ID,	new Object[] {facultyId}, new RegisterRecordMapper());
	}

	@Override
	public List<RegisterRecordBean> getAllByFacultyId(long facultyId, Connection connection) {
		return jdbcTemplate.getAll(connection, GET_REGISTRATIONS_BY_FACULTY_ID,	new Object[] {facultyId}, new RegisterRecordMapper());
	}

}
