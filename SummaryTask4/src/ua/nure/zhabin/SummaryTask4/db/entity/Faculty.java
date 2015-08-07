package ua.nure.zhabin.SummaryTask4.db.entity;

public class Faculty extends Entity {
	
	private static final long serialVersionUID = 8576328447969709905L;
	
	private String name;
	private int budget;
	private int contract;
	
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
	public int getContract() {
		return contract;
	}
	public void setContract(int contract) {
		this.contract = contract;
	}
	
	@Override
	public String toString() {
		return "Faculty [name=" + name + ", budget=" + budget + ", contract="
				+ contract + ", getId()=" + getId() + "]";
	}
}
