package ua.nure.zhabin.SummaryTask4.db.extractor;

import java.sql.ResultSet;

public interface Extractor<E> {
	
	E extract(ResultSet rs);

}
