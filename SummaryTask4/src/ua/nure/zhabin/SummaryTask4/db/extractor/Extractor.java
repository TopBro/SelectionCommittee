package ua.nure.zhabin.SummaryTask4.db.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Extractor<E> {
	
	E extract(ResultSet rs) throws SQLException;
	
}
