package ua.nure.zhabin.SummaryTask4.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zhabin.SummaryTask4.db.DBUtil;
import ua.nure.zhabin.SummaryTask4.db.extractor.Extractor;

public class DBTemplate<E> {
	
	private static final Logger LOG = Logger.getLogger(DBTemplate.class);
	
	public List<E> getAll(Connection connection, String sql, Extractor<E> extractor) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<E> list = new ArrayList<>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				E object = extractor.extract(rs);
				list.add(object);
			}
		} catch (SQLException e) {
			LOG.error("Cannot obtain objects!", e);
		} finally {
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
		return list;
	}

}
