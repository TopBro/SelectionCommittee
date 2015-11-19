package ua.nure.zhabin.SelectionCommittee.db.dao;

import java.sql.Connection;
import java.util.List;

import ua.nure.zhabin.SelectionCommittee.bean.RegisterRecordBean;

public interface RegisterDao {

	List<RegisterRecordBean> getActiveByFacultyId(long facultyId, Connection connection);
	List<RegisterRecordBean> getAllByFacultyId(long facultyId, Connection connection);

}
