package ua.nure.zhabin.SelectionCommittee.db.dao;

import java.sql.Connection;
import java.util.List;

import ua.nure.zhabin.SelectionCommittee.bean.RegisterRecordBean;

public interface RegisterDao {

	List<RegisterRecordBean> getAllByFacultyId(long facultyId,
			Connection connection);

}
