package ua.nure.zhabin.SummaryTask4.util;

import ua.nure.zhabin.SummaryTask4.bean.MarksBean;
import ua.nure.zhabin.SummaryTask4.db.entity.CertificateMarks;
import ua.nure.zhabin.SummaryTask4.db.entity.VnoMarks;

public class MarksBeanHandler {

	public static VnoMarks extractVnoMarks(MarksBean marksBean) {
		VnoMarks vnoMarks = new VnoMarks();
		vnoMarks.setUkrainian(marksBean.getUkrainian());
		vnoMarks.setMathematics(marksBean.getMathematics());
		vnoMarks.setPhysics(marksBean.getPhysics());	
		return vnoMarks;
	}
	
	public static CertificateMarks extractCertificateMarks(MarksBean marksBean) {
		CertificateMarks certificateMarks = new CertificateMarks();
		certificateMarks.setLiterature(marksBean.getLiterature());
		certificateMarks.setHistory(marksBean.getHistory());
		certificateMarks.setEnglish(marksBean.getEnglish());
		certificateMarks.setInformatics(marksBean.getInformatics());
		certificateMarks.setGeography(marksBean.getGeography());
		certificateMarks.setBiology(marksBean.getBiology());
		certificateMarks.setChemistry(marksBean.getChemistry());
		return certificateMarks;
	}
	
	public static MarksBean mapVnoMarks(MarksBean marksBean, VnoMarks vnoMarks) {
		marksBean.setUkrainian(vnoMarks.getUkrainian());
		marksBean.setMathematics(vnoMarks.getMathematics());
		marksBean.setPhysics(vnoMarks.getPhysics());
		return marksBean;
	}
	
	public static MarksBean mapCertificateMarks(MarksBean marksBean, CertificateMarks certificateMarks) {
		marksBean.setLiterature(certificateMarks.getLiterature());
		marksBean.setHistory(certificateMarks.getHistory());
		marksBean.setEnglish(certificateMarks.getEnglish());
		marksBean.setInformatics(certificateMarks.getInformatics());
		marksBean.setGeography(certificateMarks.getGeography());
		marksBean.setBiology(certificateMarks.getBiology());
		marksBean.setChemistry(certificateMarks.getChemistry());
		return marksBean;
	}	
}
