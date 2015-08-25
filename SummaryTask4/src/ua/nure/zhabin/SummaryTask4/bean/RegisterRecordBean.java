package ua.nure.zhabin.SummaryTask4.bean;

public class RegisterRecordBean {
	
	private long userId;
	private long facultyId;
	private String lastName;
	private String firstName;
	private String middleName;
	private int vnoSum;
	
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public int getVnoSum() {
		return vnoSum;
	}
	public void setVnoSum(int vnoSum) {
		this.vnoSum = vnoSum;
	}
}
