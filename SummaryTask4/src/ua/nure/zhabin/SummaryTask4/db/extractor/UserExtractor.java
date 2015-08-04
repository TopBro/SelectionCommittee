package ua.nure.zhabin.SummaryTask4.db.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import ua.nure.zhabin.SummaryTask4.db.Fields;
import ua.nure.zhabin.SummaryTask4.db.entity.User;

public class UserExtractor implements Extractor<User> {

	@Override
	public User extract(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getLong(Fields.ENTITY_ID));
		user.setLogin(rs.getString(Fields.USER_LOGIN));
		user.setPassword(rs.getString(Fields.USER_PASSWORD));
		user.setRoleId(rs.getInt(Fields.USER_ROLE_ID));
		return user;
	}
}
