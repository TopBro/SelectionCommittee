package ua.nure.zhabin.SummaryTask4.db.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionPool {
	
	private static ConnectionPool pool = null;
	private static DataSource dataSource = null;
	
	private ConnectionPool() {
		try {
			InitialContext ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/st4");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("DataSource not found");
		}
	}
	
	public static ConnectionPool getInstance() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}
	
	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
	
	public void freeConnection(Connection c) {
		try {
			c.close();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	/**
	 * Rollbacks and close the given connection.
	 * 
	 * @param con
	 *            Connection to be rollbacked and closed.
	 */
	public void rollback(Connection con) {
		if (con != null) {
			try {
				con.rollback();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				//LOG.error("Cannot rollback transaction", ex);				
			}
		}
	}
}
