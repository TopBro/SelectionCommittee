package ua.nure.zhabin.SummaryTask4.db.entity;

public class Faculty extends Entity {
	
	private static final long serialVersionUID = 8576328447969709905L;
	
	private String name;
	private int budget;
	private int total;
	private int facultyStatusId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}	
	public int getFacultyStatusId() {
		return facultyStatusId;
	}
	public void setFacultyStatusId(int facultyStatusId) {
		this.facultyStatusId = facultyStatusId;
	}
	
	@Override
	public String toString() {
		return "Faculty [name=" + name + ", budget=" + budget + ", total="
				+ total + ", getId()=" + getId() + "]";
	}
}
