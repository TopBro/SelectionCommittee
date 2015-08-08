package ua.nure.zhabin.SummaryTask4.Exception;

public class MysqlRepositoryException extends RuntimeException {

	private static final long serialVersionUID = -5424707230787898217L;
	
	public MysqlRepositoryException() {
		super();
	}
	
	public MysqlRepositoryException(String message) {
		super(message);
	}

}
