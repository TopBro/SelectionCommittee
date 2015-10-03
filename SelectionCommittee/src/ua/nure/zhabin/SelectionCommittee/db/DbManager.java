package ua.nure.zhabin.SelectionCommittee.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import ua.nure.zhabin.SelectionCommittee.exception.DbConnectionException;

/**
 * Class for working with connection to the database. Connection to the database carried out through connection pool.
 * Also contains utility methods for closing Statement and ResultSet.
 * 
 * @author Alexandr Zhabin
 *
 */
public class DbManager {
	
	private static final Logger LOG = Logger.getLogger(DbManager.class);

	/**
	 * Private method for getting the DataSource. This method used only in the getConnection method.
	 * 
	 * @return
	 * 			DataSource.
	 */
	private static DataSource getDataSource() {
		DataSource dataSource = null;
		try {
			InitialContext ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/summary4");
		} catch (Exception e) {
			LOG.error("Cannot get the DataSource!", e);
		}
		return dataSource;
	}

	/**
	 * Return a connection to the database.
	 * 
	 * @return
	 * 			Connection to the database.
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = getDataSource().getConnection();
		} catch (SQLException e) {
			LOG.error("Cannot get the connection to the database!", e);
			DbConnectionException dce = new DbConnectionException();
			dce.initCause(e);
			throw dce;
		}
		return connection;
	}

	/**
	 * Close the given Statement.
	 * 
	 * @param s
	 * 				Statement to be closed.
	 */
	public static void close(Statement s) {
		try {
			if (s != null) {
				s.close();
			}
		} catch (SQLException e) {
			LOG.error("Cannot close a Statement!", e);
		}
	}

	/**
	 * Close the given ResultSet.
	 * 
	 * @param rs
	 * 				ResultSet to be closed.
	 */
	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			LOG.error("Cannot close a ResultSet!", e);
		}
	}
	
	/**
	 * Close the given connection.
	 * 
	 * @param con
	 * 				Connection to be closed.
	 */
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			LOG.error("Cannot close the connection!", e);
		}
	}

	/**
	 * Rollbacks and close the given connection.
	 * 
	 * @param con
	 *            Connection to be rollbacked and closed.
	 */
	public static void rollback(Connection con) {
		if (con != null) {
			try {
				con.rollback();
			} catch (SQLException e) {
				 LOG.error("Cannot rollback transaction", e);
			}
		}
	}
}
