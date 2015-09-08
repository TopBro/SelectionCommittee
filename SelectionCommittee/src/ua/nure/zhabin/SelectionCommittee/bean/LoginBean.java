package ua.nure.zhabin.SelectionCommittee.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {

	private static final long serialVersionUID = -6806542623731505483L;

	private String login;
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
