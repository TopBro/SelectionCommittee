package ua.nure.zhabin.SummaryTask4.validator;

import ua.nure.zhabin.SummaryTask4.db.entity.Faculty;

public class FacultyValidator implements Validator<Faculty> {

	@Override
	public boolean isValid(Faculty bean) {
		if (bean.getName() == null || bean.getName().length() == 0 || bean.getTotal() < 1) {
			return false;
		}
		return true;
	}
}
