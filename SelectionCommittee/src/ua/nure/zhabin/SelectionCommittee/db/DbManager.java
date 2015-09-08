package ua.nure.zhabin.SelectionCommittee.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbManager {

	private static DataSource getDataSource() {
		DataSource dataSource = null;
		try {
			InitialContext ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/summary4");
		} catch (Exception e) {
			// log
		}
		return dataSource;
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = getDataSource().getConnection();
		} catch (SQLException e) {
			// log
		}
		return connection;
	}

	public static void close(Statement s) {
		try {
			if (s != null) {
				s.close();
			}
		} catch (SQLException sqle) {
			// log
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException sqle) {
			// log
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
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
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				// LOG.error("Cannot rollback transaction", ex);
			}
		}
	}
}
