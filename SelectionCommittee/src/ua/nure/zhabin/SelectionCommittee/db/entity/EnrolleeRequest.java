package ua.nure.zhabin.SelectionCommittee.db.entity;

public class EnrolleeRequest extends Entity {

	private static final long serialVersionUID = -7029544002084595503L;

	private int userId;
	private int ukrainian;
	private int mathematics;
	private int physics;
	private int certificateSum;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUkrainian() {
		return ukrainian;
	}

	public void setUkrainian(int ukrainian) {
		this.ukrainian = ukrainian;
	}

	public int getMathematics() {
		return mathematics;
	}

	public void setMathematics(int mathematics) {
		this.mathematics = mathematics;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getCertificateSum() {
		return certificateSum;
	}

	public void setCertificateSum(int certificateSum) {
		this.certificateSum = certificateSum;
	}

	@Override
	public String toString() {
		return "EnrolleeRequest [userId=" + userId + ", ukrainian=" + ukrainian
				+ ", mathematics=" + mathematics + ", physics=" + physics
				+ ", certificateSum=" + certificateSum + ", getId()=" + getId()
				+ "]";
	}
}
