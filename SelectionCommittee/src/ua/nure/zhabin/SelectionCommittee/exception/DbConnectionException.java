package ua.nure.zhabin.SelectionCommittee.exception;

public class DbConnectionException extends RuntimeException {

	private static final long serialVersionUID = 5062244051014780571L;
	
	public DbConnectionException() {
		super();
	}

	public DbConnectionException(String message) {
		super(message);
	}
}
