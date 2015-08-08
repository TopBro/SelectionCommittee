package ua.nure.zhabin.SummaryTask4.util;

import ua.nure.zhabin.SummaryTask4.bean.SignupBean;
import ua.nure.zhabin.SummaryTask4.db.Fields;
import ua.nure.zhabin.SummaryTask4.db.entity.CertificateMarks;
import ua.nure.zhabin.SummaryTask4.db.entity.Enrollee;
import ua.nure.zhabin.SummaryTask4.db.entity.User;
import ua.nure.zhabin.SummaryTask4.db.entity.VnoMarks;

public class SignupBeanExtractor {
	
	public static User extractUser(SignupBean signupBean) {
		User user = new User();
		user.setLogin(signupBean.getLogin());
		user.setPassword(signupBean.getPassword());
		user.setRoleId(Fields.ENROLLEE_ROLE);
		return user;
	}
	
	public static Enrollee extractEnrollee(SignupBean signupBean) {
		Enrollee enrollee = new Enrollee();
		enrollee.setFirstName(signupBean.getFirstName());
		enrollee.setMidleName(signupBean.getMidleName());
		enrollee.setLastName(signupBean.getLastName());
		enrollee.setEmail(signupBean.getEmail());
		enrollee.setCity(signupBean.getCity());
		enrollee.setRegion(signupBean.getRegion());
		enrollee.setEducation(signupBean.getEducation());
		enrollee.setStateId(Fields.ACTIVE_STATE);
		return enrollee;
	}
	
	public static VnoMarks extractVnoMarks(SignupBean signupBean) {
		VnoMarks vnoMarks = new VnoMarks();
		vnoMarks.setUkrainian(signupBean.getUkrainian());
		vnoMarks.setMathematics(signupBean.getMathematics());
		vnoMarks.setPhysics(signupBean.getPhysics());	
		return vnoMarks;
	}
	
	public static CertificateMarks extractCertificateMarks(SignupBean signupBean) {
		CertificateMarks certificateMarks = new CertificateMarks();
		certificateMarks.setLiterature(signupBean.getLiterature());
		certificateMarks.setHistory(signupBean.getHistory());
		certificateMarks.setEnglish(signupBean.getEnglish());
		certificateMarks.setInformatics(signupBean.getInformatics());
		certificateMarks.setGeography(signupBean.getGeography());
		certificateMarks.setBiology(signupBean.getBiology());
		certificateMarks.setChemistry(signupBean.getChemistry());
		return certificateMarks;
	}
}
