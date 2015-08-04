package ua.nure.zhabin.SummaryTask4.db.entity;

public class RegistrationRecord extends Entity {

	private static final long serialVersionUID = 2790250906992860947L;
	
	private int userId;
	private int facultyId;
	private int statusId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	@Override
	public String toString() {
		return "RegistrationRecord [userId=" + userId + ", facultyId="
				+ facultyId + ", statusId=" + statusId + ", getId()=" + getId()
				+ "]";
	}	
}
