package ua.nure.zhabin.SummaryTask4.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ua.nure.zhabin.SummaryTask4.db.Fields;
import ua.nure.zhabin.SummaryTask4.db.entity.Enrollee;

public class EnrolleeMapper implements Mapper<Enrollee> {

	@Override
	public Enrollee extract(ResultSet rs) throws SQLException {
		Enrollee enrollee = new Enrollee();
		enrollee.setId(rs.getLong(Fields.ENTITY_ID));
		enrollee.setUserId(rs.getLong(Fields.USER_ID));
		enrollee.setFirstName(rs.getString(Fields.ENROLLEE_FIRST_NAME));
		enrollee.setMidleName(rs.getString(Fields.ENROLLEE_MIDDLE_NAME));
		enrollee.setLastName(rs.getString(Fields.ENROLLEE_LAST_NAME));
		enrollee.setEmail(rs.getString(Fields.ENROLLEE_EMAIL));
		enrollee.setCity(rs.getString(Fields.ENROLLEE_CITY));
		enrollee.setRegion(rs.getString(Fields.ENROLLEE_REGION));
		enrollee.setEducation(rs.getString(Fields.ENROLLEE_EDUCATION));
		enrollee.setStateId(rs.getInt(Fields.ENROLLEE_STATE_ID));
		return enrollee;
	}
}
