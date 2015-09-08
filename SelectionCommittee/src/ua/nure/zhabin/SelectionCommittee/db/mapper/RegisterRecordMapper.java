package ua.nure.zhabin.SelectionCommittee.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ua.nure.zhabin.SelectionCommittee.bean.RegisterRecordBean;
import ua.nure.zhabin.SelectionCommittee.db.Fields;

public class RegisterRecordMapper implements Mapper<RegisterRecordBean> {

	@Override
	public RegisterRecordBean extract(ResultSet rs) throws SQLException {
		RegisterRecordBean registerRecordBean = new RegisterRecordBean();
		registerRecordBean.setUserId(rs.getLong(Fields.USER_ID));
		registerRecordBean.setFacultyId(rs.getLong(Fields.FACULTY_ID));
		registerRecordBean.setLastName(rs.getString(Fields.ENROLLEE_LAST_NAME));
		registerRecordBean.setFirstName(rs
				.getString(Fields.ENROLLEE_FIRST_NAME));
		registerRecordBean.setMiddleName(rs
				.getString(Fields.ENROLLEE_MIDDLE_NAME));
		registerRecordBean.setVnoSum(rs.getInt(6));
		return registerRecordBean;
	}
}
