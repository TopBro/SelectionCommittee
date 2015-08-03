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
	
	public E get(Connection connection, String sql, Extractor<E> extractor, int i) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		E object = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, i);
			rs = ps.executeQuery();
			while (rs.next()) {
				object = extractor.extract(rs);
			}
		} catch (SQLException e) {
			LOG.error("Cannot obtain object!", e);
		} finally {
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
		return object;
	}
	
	public E get(Connection connection, String sql, Extractor<E> extractor, String s) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		E object = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, s);
			rs = ps.executeQuery();
			while (rs.next()) {
				object = extractor.extract(rs);
			}
		} catch (SQLException e) {
			LOG.error("Cannot obtain object!", e);
		} finally {
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
		return object;
	}

	public List<E> getAllByParameter(Connection connection, Parameter parameter,
			Extractor<E> extractor) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<E> list = new ArrayList<>();
		try {
			ps = connection.prepareStatement(parameter.getSql());
			for (int i = 0; i < parameter.getParams().size(); i++) {
				ps.setObject(i + 1, parameter.getParams().get(i));
			}
			LOG.info("Complete SQL query: " + ps);
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
	
	public void add(Connection connection, String sql, Object[] arr) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < arr.length; i++) {
				ps.setObject(i + 1, arr[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			LOG.error("Cannot obtain object!", e);
		} finally {
			DBUtil.close(ps);
		}
	}
	
	
}
