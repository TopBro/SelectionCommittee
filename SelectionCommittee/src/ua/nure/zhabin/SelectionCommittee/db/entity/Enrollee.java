package ua.nure.zhabin.SelectionCommittee.db.entity;

public class Enrollee extends Entity {

	private static final long serialVersionUID = 3716801639958125064L;

	private long userId;
	private String firstName;
	private String midleName;
	private String lastName;
	private String email;
	private String city;
	private String region;
	private String education;
	private int stateId;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidleName() {
		return midleName;
	}

	public void setMidleName(String midleName) {
		this.midleName = midleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "Enrollee [userId=" + userId + ", firstName=" + firstName
				+ ", midleName=" + midleName + ", lastName=" + lastName
				+ ", email=" + email + ", city=" + city + ", region=" + region
				+ ", education=" + education + ", stateId=" + stateId
				+ ", getId()=" + getId() + "]";
	}
}
