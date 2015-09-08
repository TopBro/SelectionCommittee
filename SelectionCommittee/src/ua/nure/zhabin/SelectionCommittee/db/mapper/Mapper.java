package ua.nure.zhabin.SelectionCommittee.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<E> {

	E extract(ResultSet rs) throws SQLException;

}
