package ua.nure.zhabin.SummaryTask4.db.dao;

import java.sql.SQLException;

import ua.nure.zhabin.SummaryTask4.db.ConnectionPool;

public abstract class DaoFactory {
	
	public abstract ConnectionPool getConnectionPool() throws SQLException;
	 
	public abstract FacultyDao getCourseDAO(ConnectionPool pool);	
	public abstract UserDao getUserDAO(ConnectionPool pool);	
}
