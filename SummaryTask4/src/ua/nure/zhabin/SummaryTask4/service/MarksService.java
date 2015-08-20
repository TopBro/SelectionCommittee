package ua.nure.zhabin.SummaryTask4.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import ua.nure.zhabin.SummaryTask4.bean.MarksBean;
import ua.nure.zhabin.SummaryTask4.db.DbManager;
import ua.nure.zhabin.SummaryTask4.db.dao.MarksDao;
import ua.nure.zhabin.SummaryTask4.db.entity.CertificateMarks;
import ua.nure.zhabin.SummaryTask4.db.entity.VnoMarks;
import ua.nure.zhabin.SummaryTask4.exception.MysqlRepositoryException;
import ua.nure.zhabin.SummaryTask4.util.MarksBeanHandler;

public class MarksService {
	
	private static final Logger LOG = Logger.getLogger(MarksService.class);
	
	private MarksDao<VnoMarks> vnoMarksDao;
	private MarksDao<CertificateMarks> certificateMarksDao;
	
	public MarksService(MarksDao<VnoMarks> vnoMarksDao,	MarksDao<CertificateMarks> certificateMarksDao) {
		this.vnoMarksDao = vnoMarksDao;
		this.certificateMarksDao = certificateMarksDao;
	}
	
	public boolean isMarksExist(long userId) {
		Connection con = DbManager.getConnection();
		return vnoMarksDao.get(userId, con) != null;
	}
	
	public MarksBean getMarks(long userId) {
		Connection con = DbManager.getConnection();
		MarksBean marksBean = new MarksBean();
		VnoMarks vnoMarks = vnoMarksDao.get(userId, con);
		CertificateMarks certificateMarks = certificateMarksDao.get(userId, con);
		marksBean = MarksBeanHandler.mapVnoMarks(marksBean, vnoMarks);
		marksBean = MarksBeanHandler.mapCertificateMarks(marksBean, certificateMarks);
		return marksBean;
	}
	
	public void submitMarks(long userId, MarksBean marksBean) {
		Connection con = DbManager.getConnection();
		try {
			VnoMarks vnoMarks = MarksBeanHandler.extractVnoMarks(marksBean);
			CertificateMarks certificateMarks = MarksBeanHandler.extractCertificateMarks(marksBean);
			vnoMarks.setUserId(userId);
			certificateMarks.setUserId(userId);
			vnoMarksDao.add(vnoMarks, con);
			certificateMarksDao.add(certificateMarks, con);
			con.commit();
			LOG.info("Marks for user Id: " + userId + " have been submitted.");
		} catch (SQLException | MysqlRepositoryException e) {
			LOG.error("Cannot submit enrollee's marks. Execute rollback.", e);
			DbManager.rollback(con);
		} finally {			
			DbManager.close(con);
		}
	}
	
	public void updateMarks(long userId, MarksBean marksBean) {
		Connection con = DbManager.getConnection();
		try {
			VnoMarks vnoMarks = MarksBeanHandler.extractVnoMarks(marksBean);
			CertificateMarks certificateMarks = MarksBeanHandler.extractCertificateMarks(marksBean);
			vnoMarks.setUserId(userId);
			certificateMarks.setUserId(userId);
			vnoMarksDao.update(vnoMarks, con);
			certificateMarksDao.update(certificateMarks, con);
			con.commit();
			LOG.info("Marks for user Id: " + userId + " have been updated.");
		} catch (SQLException | MysqlRepositoryException e) {
			LOG.error("Cannot update enrollee's marks. Execute rollback.", e);
			DbManager.rollback(con);
		} finally {			
			DbManager.close(con);
		}
	}
}
