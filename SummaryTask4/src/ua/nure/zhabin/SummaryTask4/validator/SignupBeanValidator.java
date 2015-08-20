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
				bean.getEducation() == null || bean.getEducation().length() == 0) {
			return false;
		}
		return true;
	}
}
