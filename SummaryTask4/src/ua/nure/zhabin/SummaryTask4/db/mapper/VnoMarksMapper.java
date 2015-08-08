package ua.nure.zhabin.SummaryTask4.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ua.nure.zhabin.SummaryTask4.db.Fields;
import ua.nure.zhabin.SummaryTask4.db.entity.VnoMarks;

public class VnoMarksMapper implements Mapper<VnoMarks> {

	@Override
	public VnoMarks extract(ResultSet rs) throws SQLException {
		VnoMarks vnoMarks = new VnoMarks();
		vnoMarks.setId(rs.getLong(Fields.ENTITY_ID));
		vnoMarks.setUkrainian(rs.getInt(Fields.UKRAINIAN));
		vnoMarks.setMathematics(rs.getInt(Fields.MATHEMATICS));
		vnoMarks.setPhysics(rs.getInt(Fields.PHYSICS));		
		return vnoMarks;
	}
}
