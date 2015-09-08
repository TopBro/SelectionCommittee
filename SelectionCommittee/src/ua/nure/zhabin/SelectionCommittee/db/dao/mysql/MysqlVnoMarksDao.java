package ua.nure.zhabin.SelectionCommittee.db.dao.mysql;

import java.sql.Connection;

import ua.nure.zhabin.SelectionCommittee.db.JdbcTemplate;
import ua.nure.zhabin.SelectionCommittee.db.dao.MarksDao;
import ua.nure.zhabin.SelectionCommittee.db.entity.VnoMarks;
import ua.nure.zhabin.SelectionCommittee.db.mapper.VnoMarksMapper;

public class MysqlVnoMarksDao implements MarksDao<VnoMarks> {

	private static final String GET_MARKS = "Select * from vno_marks where user_id = ?";
	private static final String ADD_MARKS = "Insert into vno_marks values(default, ?, ?, ?, ?)";
	private static final String UPDATE_MARKS = "Update vno_marks "
			+ "set ukrainian=?, mathematics=?, physics=? " + "where user_id=?";

	private JdbcTemplate<VnoMarks> jdbcTemplate;

	public MysqlVnoMarksDao() {
		this.jdbcTemplate = new JdbcTemplate<>();
	}

	@Override
	public VnoMarks get(long userId, Connection connection) {
		return jdbcTemplate.get(connection, GET_MARKS, new Object[] { userId },
				new VnoMarksMapper());
	}

	@Override
	public void add(VnoMarks marks, Connection connection) {
		jdbcTemplate.update(
				connection,
				ADD_MARKS,
				new Object[] { marks.getUserId(), marks.getUkrainian(),
						marks.getMathematics(), marks.getPhysics() });
	}

	@Override
	public void update(VnoMarks marks, Connection connection) {
		jdbcTemplate.update(connection, UPDATE_MARKS,
				new Object[] { marks.getUkrainian(), marks.getMathematics(),
						marks.getPhysics(), marks.getUserId() });
	}
}
