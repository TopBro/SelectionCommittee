package ua.nure.zhabin.SummaryTask4.db.entity;

public class VnoMarks extends Entity {

	private static final long serialVersionUID = -6390211836251096843L;
	
	private long userId;
	private int ukrainian;
	private int mathematics;
	private int physics;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
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
	
	@Override
	public String toString() {
		return "VnoMarks [userId=" + userId + ", ukrainian=" + ukrainian
				+ ", mathematics=" + mathematics + ", physics=" + physics
				+ ", getId()=" + getId() + "]";
	}
}
