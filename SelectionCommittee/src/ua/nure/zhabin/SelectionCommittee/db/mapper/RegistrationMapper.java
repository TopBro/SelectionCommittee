package ua.nure.zhabin.SelectionCommittee.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ua.nure.zhabin.SelectionCommittee.db.entity.RegistrationRecord;

public class RegistrationMapper implements Mapper<RegistrationRecord> {

	@Override
	public RegistrationRecord extract(ResultSet rs) throws SQLException {
		RegistrationRecord registrationRecord = new RegistrationRecord();
		registrationRecord.setFacultyName(rs.getString(1));
		registrationRecord.setStatusName(rs.getString(2));
		return registrationRecord;
	}

}
