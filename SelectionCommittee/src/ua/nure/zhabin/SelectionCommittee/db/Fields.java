package ua.nure.zhabin.SelectionCommittee.db;

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

	public static final int REGISTRATION_STATUS_WAITING = 1;

	public static final int FACULTY_OPEN = 1;
	public static final int FACULTY_CLOSED = 2;

	public static final String ENTITY_ID = "id";

	public static final String REGISTRATION_STATUS_ID = "status_id";

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

	public static final String UKRAINIAN = "ukrainian";
	public static final String MATHEMATICS = "mathematics";
	public static final String PHYSICS = "physics";
	public static final String LITERATURE = "literature";
	public static final String HISTORY = "history";
	public static final String ENGLISH = "english";
	public static final String INFORMATICS = "informatics";
	public static final String GEOGRAPHY = "geography";
	public static final String BIOLOGY = "biology";
	public static final String CHEMISTRY = "chemistry";

	public static final String FACULTY_ID = "faculty_id";
	public static final String FACULTY_NAME = "name";
	public static final String FACULTY_BUDGET = "budget";
	public static final String FACULTY_TOTAL = "total";
	public static final String FACULTY_STATUS_ID = "faculty_status_id";
}