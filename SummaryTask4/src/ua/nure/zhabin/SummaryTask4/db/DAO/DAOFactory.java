package ua.nure.zhabin.SummaryTask4.db.DAO;

import java.sql.SQLException;

public abstract class DAOFactory {
	
	public static final int MYSQL = 1;
	
	public abstract ConnectionPool getConnectionPool() throws SQLException;
	 
	public abstract CourseDAO getCourseDAO(ConnectionPool pool);	
	public abstract TopicDAO getTopicDAO(ConnectionPool pool);
	public abstract UserDAO getUserDAO(ConnectionPool pool);	
}
