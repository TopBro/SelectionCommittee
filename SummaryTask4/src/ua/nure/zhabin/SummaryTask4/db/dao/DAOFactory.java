package ua.nure.zhabin.SummaryTask4.db.dao;

import java.sql.SQLException;

import ua.nure.zhabin.SummaryTask4.db.ConnectionPool;

public abstract class DAOFactory {
	
	public abstract ConnectionPool getConnectionPool() throws SQLException;
	 
	public abstract FacultyDAO getCourseDAO(ConnectionPool pool);	
	public abstract UserDAO getUserDAO(ConnectionPool pool);	
}
