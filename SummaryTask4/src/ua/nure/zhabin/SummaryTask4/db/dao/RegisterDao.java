package ua.nure.zhabin.SummaryTask4.db.dao;

import java.sql.Connection;
import java.util.List;

import ua.nure.zhabin.SummaryTask4.bean.RegisterRecordBean;

public interface RegisterDao {

	List<RegisterRecordBean> getAllByFacultyId(long facultyId, Connection connection);
	
}
