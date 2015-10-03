package ua.nure.zhabin.SelectionCommittee.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zhabin.SelectionCommittee.bean.RegisterRecordBean;
import ua.nure.zhabin.SelectionCommittee.db.DbManager;
import ua.nure.zhabin.SelectionCommittee.db.Fields;
import ua.nure.zhabin.SelectionCommittee.db.dao.EnrolleeDao;
import ua.nure.zhabin.SelectionCommittee.db.dao.FacultyDao;
import ua.nure.zhabin.SelectionCommittee.db.dao.RegisterDao;
import ua.nure.zhabin.SelectionCommittee.db.dao.RegistrationDao;
import ua.nure.zhabin.SelectionCommittee.db.entity.Enrollee;
import ua.nure.zhabin.SelectionCommittee.db.entity.Faculty;
import ua.nure.zhabin.SelectionCommittee.db.entity.RegistrationRecord;
import ua.nure.zhabin.SelectionCommittee.exception.MysqlRepositoryException;

public class RegistrationService {

	private static final Logger LOG = Logger.getLogger(RegistrationService.class);

	private RegistrationDao registrationDao;
	private EnrolleeDao enrolleeDao;
	private FacultyDao facultyDao;
	private RegisterDao registerDao;

	public RegistrationService(RegistrationDao registrationDao,
			EnrolleeDao enrolleeDao, FacultyDao facultyDao,
			RegisterDao registerDao) {
		this.registrationDao = registrationDao;
		this.enrolleeDao = enrolleeDao;
		this.facultyDao = facultyDao;
		this.registerDao = registerDao;
	}

	public boolean isFacultyClosed(long facultyId) {
		Connection con = DbManager.getConnection();
		Faculty faculty = facultyDao.getById(facultyId, con);
		return faculty.getFacultyStatusId() == Fields.FACULTY_CLOSED;
	}

	public boolean isEnrolleeBlocked(long userId) {
		Connection con = DbManager.getConnection();
		Enrollee enrollee = enrolleeDao.get(userId, con);
		return enrollee.getStateId() == Fields.BLOCKED_STATE;
	}

	public boolean isRegistrationRecordExist(long userId, long facultyId) {
		Connection con = DbManager.getConnection();
		return registrationDao.get(userId, facultyId, con) != null;
	}

	public List<RegistrationRecord> getAllByUserId(long userId) {
		Connection con = DbManager.getConnection();
		return registrationDao.getAllByUserId(userId, con);
	}

	public List<RegisterRecordBean> getAllByFacultyId(long facultyId) {
		Connection con = DbManager.getConnection();
		return registerDao.getAllByFacultyId(facultyId, con);
	}

	public void addRegistrationRecord(long userId, long facultyId) {
		Connection con = DbManager.getConnection();
		try {
			registrationDao.add(userId, facultyId, con);
			con.commit();
		} catch (SQLException | MysqlRepositoryException e) {
			LOG.error("Cannot create registration record. Execute rollback.", e);
			DbManager.rollback(con);
		} finally {
			DbManager.close(con);
		}
		LOG.info("Registration record for user Id: " + userId
				+ " has been added.");
	}

	public void updateRegistrationRecordStatus(
			RegistrationRecord registrationRecord) {
		Connection con = DbManager.getConnection();
		try {
			registrationDao.updateStatus(registrationRecord, con);
			con.commit();
		} catch (SQLException | MysqlRepositoryException e) {
			LOG.error("Cannot create registration record. Execute rollback.", e);
			DbManager.rollback(con);
		} finally {
			DbManager.close(con);
		}
		LOG.info("Status of registration record for user Id: "
				+ registrationRecord.getUserId() + " has been updated.");
	}
}
