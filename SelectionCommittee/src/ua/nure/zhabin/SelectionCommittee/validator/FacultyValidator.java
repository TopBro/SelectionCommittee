package ua.nure.zhabin.SelectionCommittee.validator;

import ua.nure.zhabin.SelectionCommittee.db.entity.Faculty;

public class FacultyValidator implements Validator<Faculty> {

	@Override
	public boolean isValid(Faculty bean) {
		if (bean.getName() == null || bean.getName().length() == 0
				|| bean.getTotal() < 1) {
			return false;
		}
		return true;
	}
}
