package ua.nure.zhabin.SummaryTask4.db.dao.mysql;

import java.sql.Connection;
import java.util.List;

import ua.nure.zhabin.SummaryTask4.bean.RegisterRecordBean;
import ua.nure.zhabin.SummaryTask4.db.JdbcTemplate;
import ua.nure.zhabin.SummaryTask4.db.dao.RegisterDao;
import ua.nure.zhabin.SummaryTask4.db.mapper.RegisterRecordMapper;

public class MysqlRegisterDao implements RegisterDao {
	
	private static final String GET_REGISTRATIONS_BY_FACULTY_ID = "select r.user_id, r.faculty_id, e.last_name, "
			+ "e.first_name, e.middle_name, vm.ukrainian + vm.mathematics + vm.physics from registrations as r "
			+ "join enrollees as e on e.user_id = r.user_id join vno_marks as vm on vm.user_id = r.user_id and r.faculty_id = ?";

	private JdbcTemplate<RegisterRecordBean> jdbcTemplate;
	
	public MysqlRegisterDao() {
		jdbcTemplate = new JdbcTemplate<>();
	}
	
	@Override
	public List<RegisterRecordBean> getAllByFacultyId(long facultyId, Connection connection) {
		return jdbcTemplate.getAll(connection, GET_REGISTRATIONS_BY_FACULTY_ID, new Object[] {facultyId}, new RegisterRecordMapper());
	}

}
