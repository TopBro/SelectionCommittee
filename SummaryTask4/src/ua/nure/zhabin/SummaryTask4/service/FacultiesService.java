package ua.nure.zhabin.SummaryTask4.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zhabin.SummaryTask4.db.DbManager;
import ua.nure.zhabin.SummaryTask4.db.Fields;
import ua.nure.zhabin.SummaryTask4.db.dao.FacultyDao;
import ua.nure.zhabin.SummaryTask4.db.entity.Faculty;
import ua.nure.zhabin.SummaryTask4.exception.MysqlRepositoryException;

public class FacultiesService {
	
	private static final Logger LOG = Logger.getLogger(UserService.class);
	
	private FacultyDao facultyDao;
	
	public FacultiesService(FacultyDao facultyDao) {
		this.facultyDao = facultyDao;
	}
	
	public boolean isFacultyExistById(long facultyId) {
		Connection con = DbManager.getConnection();
		return facultyDao.getById(facultyId, con) != null;
	}
	
	public boolean isFacultyExistByName(String name) {
		Connection con = DbManager.getConnection();
		return facultyDao.getByName(name, con) != null;
	}
	
	public Faculty getFaculty(long facultyId) {
		Connection con = DbManager.getConnection();
		return facultyDao.getById(facultyId, con);
	}
	
	public List<Faculty> getAllFaculties() {
		Connection con = DbManager.getConnection();
		return facultyDao.getAll(con);
	}
	
	public void update(Faculty faculty) {
		Connection con = DbManager.getConnection();
		try {
			facultyDao.update(faculty, con);
			con.commit();
		} catch (SQLException | MysqlRepositoryException e) {
			LOG.error("Cannot update faculty. Execute rollback.", e);
			DbManager.rollback(con);
		} finally {			
			DbManager.close(con);
		}
	}
	
	public void add(Faculty faculty) {
		Connection con = DbManager.getConnection();
		try {
			faculty.setFacultyStatusId(Fields.FACULTY_OPEN);
			facultyDao.add(faculty, con);
			con.commit();
		} catch (SQLException | MysqlRepositoryException e) {
			LOG.error("Cannot add faculty. Execute rollback.", e);
			DbManager.rollback(con);
		} finally {			
			DbManager.close(con);
		}
	}
	
	public void delete(long facultyId) {
		Connection con = DbManager.getConnection();
		try {
			facultyDao.delete(facultyId, con);
			con.commit();
		} catch (SQLException | MysqlRepositoryException e) {
			LOG.error("Cannot delete faculty. Execute rollback.", e);
			DbManager.rollback(con);
		} finally {			
			DbManager.close(con);
		}
	}

}
