package ua.nure.zhabin.SummaryTask4.db.entity;

/**
 * Entity of Role
 * 
 * @author A.Zhabin
 *
 */
public enum Role {
	ADMIN, ENROLLEE;

	public static Role getRole(User user) {
		int roleId = user.getRoleId();
		return Role.values()[roleId];
	}
	
	public String getName() {
		return name().toLowerCase();
	}
}
