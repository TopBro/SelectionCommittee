package ua.nure.zhabin.SummaryTask4.db;

/**
 * Holder for fields names of DB tables and beans.
 * 
 * @author A.Zhabin
 * 
 */
public final class Fields {
	
	public static final int ADMIN_ROLE = 1;
	public static final int ENROLLEE_ROLE = 2;
	
	public static final int ACTIVE_STATE = 1;
	public static final int BLOCKED_STATE = 2;
		
	public static final String ENTITY_ID = "id";
	
	public static final String USER_ID = "user_id";
	public static final String USER_LOGIN = "login";
	public static final String USER_PASSWORD = "password";	
	public static final String USER_ROLE_ID = "role_id";
	
	public static final String ENROLLEE_FIRST_NAME = "first_name"; 
	public static final String ENROLLEE_MIDDLE_NAME = "middle_name";
	public static final String ENROLLEE_LAST_NAME = "last_name";	
	public static final String ENROLLEE_EMAIL = "email";
	public static final String ENROLLEE_CITY = "city";
	public static final String ENROLLEE_REGION = "region";
	public static final String ENROLLEE_EDUCATION = "education";
	public static final String ENROLLEE_STATE_ID = "state_id";
	
}