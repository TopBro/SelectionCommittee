package ua.nure.zhabin.SelectionCommittee.validator;

import ua.nure.zhabin.SelectionCommittee.bean.MarksBean;

public class MarksBeanValidator implements Validator<MarksBean> {

	private static final int MIN_VNO_MARK = 100;
	private static final int MAX_VNO_MARK = 200;
	private static final int MAX_CERTIFICATE_MARK = 12;

	@Override
	public boolean isValid(MarksBean bean) {
		if (bean.getUkrainian() < MIN_VNO_MARK
				|| bean.getUkrainian() > MAX_VNO_MARK
				|| bean.getMathematics() < MIN_VNO_MARK
				|| bean.getMathematics() > MAX_VNO_MARK
				|| bean.getPhysics() < MIN_VNO_MARK
				|| bean.getPhysics() > MAX_VNO_MARK || bean.getLiterature() < 1
				|| bean.getLiterature() > MAX_CERTIFICATE_MARK
				|| bean.getHistory() < 1
				|| bean.getHistory() > MAX_CERTIFICATE_MARK
				|| bean.getEnglish() < 1
				|| bean.getEnglish() > MAX_CERTIFICATE_MARK
				|| bean.getInformatics() < 1
				|| bean.getInformatics() > MAX_CERTIFICATE_MARK
				|| bean.getGeography() < 1
				|| bean.getGeography() > MAX_CERTIFICATE_MARK
				|| bean.getBiology() < 1
				|| bean.getBiology() > MAX_CERTIFICATE_MARK
				|| bean.getChemistry() < 1
				|| bean.getChemistry() > MAX_CERTIFICATE_MARK) {
			return false;
		}
		return true;
	}
}
