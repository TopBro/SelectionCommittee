package ua.nure.zhabin.SummaryTask4.db.dao.mysql;

import java.sql.Connection;

import ua.nure.zhabin.SummaryTask4.db.JdbcTemplate;
import ua.nure.zhabin.SummaryTask4.db.dao.MarksDao;
import ua.nure.zhabin.SummaryTask4.db.entity.CertificateMarks;
import ua.nure.zhabin.SummaryTask4.db.entity.VnoMarks;

public class MysqlCertificateMarksDao implements MarksDao<CertificateMarks> {

	private static final String ADD_MARKS= "Insert into certificate_marks "
			+ "values(default, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private JdbcTemplate<VnoMarks> jdbcTemplate;
	
	public MysqlCertificateMarksDao() {
		jdbcTemplate = new JdbcTemplate<>();
	}
	
	@Override
	public void add(CertificateMarks marks, Connection connection) {
		jdbcTemplate.update(connection, ADD_MARKS, new Object[] {marks.getUserId(),
				marks.getLiterature(), marks.getHistory(), marks.getEnglish(),
				marks.getInformatics(), marks.getGeography(), marks.getBiology(), 
				marks.getChemistry()}); 		
	}
}
