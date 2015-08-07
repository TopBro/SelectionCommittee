package ua.nure.zhabin.SummaryTask4.db.entity;

public class CertificateMarks extends Entity {

	private static final long serialVersionUID = -2291287467338133156L;
	
	private long userId;
	private int literature;
	private int history;
	private int english;
	private int informatics;
	private int geography;
	private int biology;
	private int chemistry;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getLiterature() {
		return literature;
	}
	public void setLiterature(int literature) {
		this.literature = literature;
	}
	public int getHistory() {
		return history;
	}
	public void setHistory(int history) {
		this.history = history;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getInformatics() {
		return informatics;
	}
	public void setInformatics(int informatics) {
		this.informatics = informatics;
	}
	public int getGeography() {
		return geography;
	}
	public void setGeography(int geography) {
		this.geography = geography;
	}
	public int getBiology() {
		return biology;
	}
	public void setBiology(int biology) {
		this.biology = biology;
	}
	public int getChemistry() {
		return chemistry;
	}
	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}
	
	@Override
	public String toString() {
		return "Certificate [userId=" + userId + ", literature=" + literature
				+ ", history=" + history + ", english=" + english
				+ ", informatics=" + informatics + ", geography=" + geography
				+ ", biology=" + biology + ", chemistry=" + chemistry
				+ ", getId()=" + getId() + "]";
	}
}
