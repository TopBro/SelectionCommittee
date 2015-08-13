package ua.nure.zhabin.SummaryTask4.db.dao.mysql;

import java.sql.Connection;

import ua.nure.zhabin.SummaryTask4.db.JdbcTemplate;
import ua.nure.zhabin.SummaryTask4.db.dao.MarksDao;
import ua.nure.zhabin.SummaryTask4.db.entity.VnoMarks;

public class MysqlVnoMarksDao implements MarksDao<VnoMarks> {

	private static final String ADD_MARKS= "Insert into vno_marks values(default, ?, ?, ?, ?)";
	
	private JdbcTemplate<VnoMarks> jdbcTemplate;
	
	public MysqlVnoMarksDao() {
		this.jdbcTemplate = new JdbcTemplate<>();
	}
	
	@Override
	public void add(VnoMarks marks, Connection connection) {
		jdbcTemplate.update(connection, ADD_MARKS, new Object[] {marks.getUserId(), 
				marks.getUkrainian(), marks.getMathematics(), marks.getPhysics()}); 		
	}
}
