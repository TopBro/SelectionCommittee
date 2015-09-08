package ua.nure.zhabin.SelectionCommittee.db.dao.mysql;

import java.sql.Connection;

import ua.nure.zhabin.SelectionCommittee.db.JdbcTemplate;
import ua.nure.zhabin.SelectionCommittee.db.dao.MarksDao;
import ua.nure.zhabin.SelectionCommittee.db.entity.CertificateMarks;
import ua.nure.zhabin.SelectionCommittee.db.mapper.CertificateMarksMapper;

public class MysqlCertificateMarksDao implements MarksDao<CertificateMarks> {

	private static final String GET_MARKS = "Select * from certificate_marks where user_id = ?";
	private static final String ADD_MARKS = "Insert into certificate_marks "
			+ "values(default, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_MARKS = "Update certificate_marks "
			+ "set literature=?, history=?, english=?, informatics=?, geography=?, biology=?, chemistry=? "
			+ "where user_id=?";

	private JdbcTemplate<CertificateMarks> jdbcTemplate;

	public MysqlCertificateMarksDao() {
		this.jdbcTemplate = new JdbcTemplate<>();
	}

	@Override
	public CertificateMarks get(long userId, Connection connection) {
		return jdbcTemplate.get(connection, GET_MARKS, new Object[] { userId },
				new CertificateMarksMapper());
	}

	@Override
	public void add(CertificateMarks marks, Connection connection) {
		jdbcTemplate.update(
				connection,
				ADD_MARKS,
				new Object[] { marks.getUserId(), marks.getLiterature(),
						marks.getHistory(), marks.getEnglish(),
						marks.getInformatics(), marks.getGeography(),
						marks.getBiology(), marks.getChemistry() });
	}

	@Override
	public void update(CertificateMarks marks, Connection connection) {
		jdbcTemplate.update(
				connection,
				UPDATE_MARKS,
				new Object[] { marks.getLiterature(), marks.getHistory(),
						marks.getEnglish(), marks.getInformatics(),
						marks.getGeography(), marks.getBiology(),
						marks.getChemistry(), marks.getUserId() });
	}
}
