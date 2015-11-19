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

	public RegistrationService(RegistrationDao registrationDao,	EnrolleeDao enrolleeDao, FacultyDao facultyDao,
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

	public List<RegisterRecordBean> getAllActiveByFacultyId(long facultyId) {
		Connection con = DbManager.getConnection();
		return registerDao.getActiveByFacultyId(facultyId, con);
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
		LOG.info("Registration record for user Id: " + userId + " has been added.");
	}

	public void updateRegistrationRecordStatus(int statusId, long userId, long facultyId) {
		Connection con = DbManager.getConnection();
		try {
			registrationDao.updateStatus(statusId, userId, facultyId, con);
			con.commit();
		} catch (SQLException | MysqlRepositoryException e) {
			LOG.error("Cannot create registration record. Execute rollback.", e);
			DbManager.rollback(con);
		} finally {
			DbManager.close(con);
		}
		LOG.info("Status of registration record for user Id: " + userId + " has been updated.");
	}
	
	public void closeRegister(long facultyId) {
		Connection con = DbManager.getConnection();
		Faculty faculty = facultyDao.getById(facultyId, con);
		List<RegisterRecordBean> list = registerDao.getActiveByFacultyId(facultyId, con);
		int i = 0;
		try {
			while (i < faculty.getBudget() && i < list.size()) {
				registrationDao.updateStatus(Fields.REGISTRATION_STATUS_BUDGET, list.get(i).getUserId(), facultyId, con);
				i++;
			}
			i = faculty.getBudget();
			while (i < faculty.getTotal() && i < list.size()) {
				registrationDao.updateStatus(Fields.REGISTRATION_STATUS_CONTRACT, list.get(i).getUserId(), facultyId, con);
				i++;
			}
			i = faculty.getTotal();
			while (i < list.size()) {
				registrationDao.updateStatus(Fields.REGISTRATION_STATUS_NOT_ENROLLED, list.get(i).getUserId(), facultyId, con);
				i++;
			}
			facultyDao.updateStatus(Fields.FACULTY_CLOSED, facultyId, con);
			con.commit();
		} catch (SQLException | MysqlRepositoryException e) {
			LOG.error("Cannot close register. Execute rollback.", e);
			DbManager.rollback(con);
		} finally {
			DbManager.close(con);
		}
		LOG.info("Register of faculty with ID: " + facultyId + " has been closed.");
	}
	
	public void openRegister(long facultyId) {
		Connection con = DbManager.getConnection();
		List<RegisterRecordBean> list = registerDao.getAllByFacultyId(facultyId, con);
		try {
			for (int i = 0; i < list.size(); i++) {
				registrationDao.updateStatus(Fields.REGISTRATION_STATUS_WAITING, list.get(i).getUserId(), facultyId, con);
			}
			facultyDao.updateStatus(Fields.FACULTY_OPEN, facultyId, con);
			con.commit();
		} catch (SQLException | MysqlRepositoryException e) {
			LOG.error("Cannot open register. Execute rollback.", e);
			DbManager.rollback(con);
		} finally {
			DbManager.close(con);
		}
		LOG.info("Register of faculty with ID: " + facultyId + " has been opened.");
	}
}
