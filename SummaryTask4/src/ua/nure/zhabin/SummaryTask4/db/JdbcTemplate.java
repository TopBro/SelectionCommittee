package ua.nure.zhabin.SummaryTask4.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zhabin.SummaryTask4.db.DbManager;
import ua.nure.zhabin.SummaryTask4.db.mapper.Mapper;
import ua.nure.zhabin.SummaryTask4.exception.MysqlRepositoryException;

public class JdbcTemplate<E> {
	
	private static final Logger LOG = Logger.getLogger(JdbcTemplate.class);
	
	public List<E> getAll(Connection connection, String sql, Mapper<E> extractor) {
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
			MysqlRepositoryException mre = new MysqlRepositoryException(e.getMessage());
			mre.initCause(e);
			throw mre;
		} finally {
			DbManager.close(ps);
			DbManager.close(rs);
		}
		return list;
	}
	
	public E get(Connection connection, String sql, Object[] arr, Mapper<E> extractor) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		E object = null;
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < arr.length; i++) {
				ps.setObject(i + 1, arr[i]);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				object = extractor.extract(rs);
			}
		} catch (SQLException e) {
			LOG.error("Cannot obtain object!", e);
			MysqlRepositoryException mre = new MysqlRepositoryException(e.getMessage());
			mre.initCause(e);
			throw mre;
		} finally {
			DbManager.close(ps);
			DbManager.close(rs);
		}
		return object;
	}
	
	/*public List<E> getAllByParameter(Connection connection, Parameter parameter,
			Mapper<E> extractor) {
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
			MysqlRepositoryException mre = new MysqlRepositoryException(e.getMessage());
			mre.initCause(e);
			throw mre;
		} finally {
			DbUtil.close(ps);
			DbUtil.close(rs);
		}
		return list;
	}*/	
	
	public void update(Connection connection, String sql, Object[] arr) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < arr.length; i++) {
				ps.setObject(i + 1, arr[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			LOG.error("Cannot obtain object!", e);
			MysqlRepositoryException mre = new MysqlRepositoryException(e.getMessage());
			mre.initCause(e);
			throw mre;
		} finally {
			DbManager.close(ps);
		}
	}
	
	public long createUser(Connection connection, String sql, Object[] arr) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		long key = 0;
		try {
			ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < arr.length; i++) {
				ps.setObject(i + 1, arr[i]);
			}
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
			    key = rs.getLong(1);
			}
		} catch (SQLException e) {
			LOG.error("Cannot obtain object!", e);
			MysqlRepositoryException mre = new MysqlRepositoryException(e.getMessage());
			mre.initCause(e);
			throw mre;
		} finally {
			DbManager.close(ps);
			DbManager.close(rs);
		}
		return key;
	}
}
