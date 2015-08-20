package ua.nure.zhabin.SummaryTask4.db.entity;

public class RegistrationRecord extends Entity {

	private static final long serialVersionUID = 2790250906992860947L;
	
	private long userId;
	private long facultyId;
	private int statusId;
	private String facultyName;
	private String statusName;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(long facultyId) {
		this.facultyId = facultyId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}	
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	@Override
	public String toString() {
		return "RegistrationRecord [userId=" + userId + ", facultyId="
				+ facultyId + ", statusId=" + statusId + ", getId()=" + getId()
				+ "]";
	}	
}
