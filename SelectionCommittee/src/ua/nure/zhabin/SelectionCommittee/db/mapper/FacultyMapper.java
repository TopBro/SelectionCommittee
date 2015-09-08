package ua.nure.zhabin.SelectionCommittee.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ua.nure.zhabin.SelectionCommittee.db.Fields;
import ua.nure.zhabin.SelectionCommittee.db.entity.Faculty;

public class FacultyMapper implements Mapper<Faculty> {

	@Override
	public Faculty extract(ResultSet rs) throws SQLException {
		Faculty faculty = new Faculty();
		faculty.setId(rs.getLong(Fields.ENTITY_ID));
		faculty.setName(rs.getString(Fields.FACULTY_NAME));
		faculty.setBudget(rs.getInt(Fields.FACULTY_BUDGET));
		faculty.setTotal(rs.getInt(Fields.FACULTY_TOTAL));
		faculty.setFacultyStatusId(rs.getInt(Fields.FACULTY_STATUS_ID));
		return faculty;
	}

}
