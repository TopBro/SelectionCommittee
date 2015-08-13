package ua.nure.zhabin.SummaryTask4.validator;

import ua.nure.zhabin.SummaryTask4.bean.SignupBean;

public class SignupBeanValidator implements Validator<SignupBean> {

	@Override
	public boolean isValid(SignupBean bean) {
		if (bean.getLogin() == null || bean.getLogin().length() == 0 ||
				bean.getPassword() == null || bean.getPassword().length() == 0 ||
				bean.getFirstName() == null || bean.getFirstName().length() == 0 ||
				bean.getMidleName() == null || bean.getMidleName().length() == 0 ||
				bean.getLastName() == null || bean.getLastName().length() == 0 ||
				bean.getEmail() == null || bean.getEmail().length() == 0 ||
				bean.getCity() == null || bean.getCity().length() == 0 ||
				bean.getRegion() == null || bean.getRegion().length() == 0 ||
				bean.getEducation() == null || bean.getEducation().length() == 0 ||
				bean.getUkrainian() == 0 || bean.getMathematics() == 0 || bean.getPhysics() == 0 ||
				bean.getLiterature() == 0 || bean.getHistory() == 0 || bean.getEnglish() == 0 ||
				bean.getInformatics() == 0 || bean.getGeography() == 0 || bean.getBiology() == 0 ||
				bean.getChemistry() == 0) {
			return false;
		}
		return true;
	}
}
