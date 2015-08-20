package ua.nure.zhabin.SummaryTask4.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ua.nure.zhabin.SummaryTask4.db.Fields;
import ua.nure.zhabin.SummaryTask4.db.entity.CertificateMarks;

public class CertificateMarksMapper implements Mapper<CertificateMarks> {

	@Override
	public CertificateMarks extract(ResultSet rs) throws SQLException {
		CertificateMarks certificateMarks = new CertificateMarks();
		certificateMarks.setId(rs.getLong(Fields.ENTITY_ID));
		certificateMarks.setUserId(rs.getLong(Fields.USER_ID));
		certificateMarks.setLiterature(rs.getInt(Fields.LITERATURE));
		certificateMarks.setHistory(rs.getInt(Fields.HISTORY));
		certificateMarks.setEnglish(rs.getInt(Fields.ENGLISH));
		certificateMarks.setInformatics(rs.getInt(Fields.INFORMATICS));
		certificateMarks.setGeography(rs.getInt(Fields.GEOGRAPHY));
		certificateMarks.setBiology(rs.getInt(Fields.BIOLOGY));
		certificateMarks.setChemistry(rs.getInt(Fields.CHEMISTRY));
		return certificateMarks;
	}
}
