package ua.nure.zhabin.SelectionCommittee.bean;

import java.io.Serializable;

public class MarksBean implements Serializable {

	private static final long serialVersionUID = 4114983643997457109L;

	private int ukrainian;
	private int mathematics;
	private int physics;
	private int literature;
	private int history;
	private int english;
	private int informatics;
	private int geography;
	private int biology;
	private int chemistry;

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
}
