package ua.nure.zhabin.SelectionCommittee.util;

import ua.nure.zhabin.SelectionCommittee.bean.SignupBean;
import ua.nure.zhabin.SelectionCommittee.db.Fields;
import ua.nure.zhabin.SelectionCommittee.db.entity.Enrollee;
import ua.nure.zhabin.SelectionCommittee.db.entity.User;

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
}
