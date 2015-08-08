package ua.nure.zhabin.SummaryTask4.service;

import java.sql.Connection;

import ua.nure.zhabin.SummaryTask4.Exception.MysqlRepositoryException;
import ua.nure.zhabin.SummaryTask4.bean.SignupBean;
import ua.nure.zhabin.SummaryTask4.db.DbManager;
import ua.nure.zhabin.SummaryTask4.db.dao.EnrolleeDao;
import ua.nure.zhabin.SummaryTask4.db.dao.MarksDao;
import ua.nure.zhabin.SummaryTask4.db.dao.UserDao;
import ua.nure.zhabin.SummaryTask4.db.entity.CertificateMarks;
import ua.nure.zhabin.SummaryTask4.db.entity.Enrollee;
import ua.nure.zhabin.SummaryTask4.db.entity.User;
import ua.nure.zhabin.SummaryTask4.db.entity.VnoMarks;
import ua.nure.zhabin.SummaryTask4.util.SignupBeanExtractor;

public class UserService {

	private UserDao userDao;
	private EnrolleeDao enrolleeDao;
	private MarksDao<VnoMarks> vnoMarksDao;
	private MarksDao<CertificateMarks> certificateMarksDao;
	
	public UserService(UserDao userDao, EnrolleeDao enrolleeDao, MarksDao<VnoMarks> vnoMarksDao,
			MarksDao<CertificateMarks> certificateMarksDao) {
		this.userDao = userDao;
		this.enrolleeDao = enrolleeDao;
		this.vnoMarksDao = vnoMarksDao;
		this.certificateMarksDao = certificateMarksDao;
	}
	
	public boolean isUserExist(String login) {
		Connection con = DbManager.getConnection();
		return userDao.get(login, con) != null;
	}
	
	public void createUser(SignupBean signupBean) {
		Connection con = DbManager.getConnection();
		try {
			User user = SignupBeanExtractor.extractUser(signupBean);
			Enrollee enrollee = SignupBeanExtractor.extractEnrollee(signupBean);
			VnoMarks vnoMarks = SignupBeanExtractor.extractVnoMarks(signupBean);
			CertificateMarks certificateMarks = SignupBeanExtractor.extractCertificateMarks(signupBean);
			long userId = userDao.add(user, con);		
			enrollee.setUserId(userId);
			vnoMarks.setUserId(userId);
			certificateMarks.setUserId(userId);
			enrolleeDao.add(enrollee, con);
			vnoMarksDao.add(vnoMarks, con);
			certificateMarksDao.add(certificateMarks, con);
		} catch (MysqlRepositoryException mre) {
			DbManager.rollback(con);
		} finally {			
			DbManager.close(con);
		}		
	}
}
