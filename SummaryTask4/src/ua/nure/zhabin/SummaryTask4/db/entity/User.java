package ua.nure.zhabin.SummaryTask4.db.entity;

public class User extends Entity{

	private static final long serialVersionUID = -8764702440891198927L;
	
	private String login;	
	private String password;	
	private int roleId;	
	
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
	
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password
				+ ", roleId=" + roleId + ", getId()=" + getId() + "]";
	}
}
