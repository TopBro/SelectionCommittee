package ua.nure.zhabin.SummaryTask4.db.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
	public static void close(Statement s) {
		
		try {
			if (s != null)
				s.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
		
	public static void close(ResultSet rs) {
		
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
