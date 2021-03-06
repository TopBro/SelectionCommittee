package ua.nure.zhabin.SelectionCommittee.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zhabin.SelectionCommittee.db.DbManager;
import ua.nure.zhabin.SelectionCommittee.db.mapper.Mapper;
import ua.nure.zhabin.SelectionCommittee.exception.MysqlRepositoryException;

public class JdbcTemplate<E> {

	private static final Logger LOG = Logger.getLogger(JdbcTemplate.class);

	public List<E> getAll(Connection connection, String sql, Object[] arr, Mapper<E> mapper) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<E> list = new ArrayList<>();
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < arr.length; i++) {
				ps.setObject(i + 1, arr[i]);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				E object = mapper.extract(rs);
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

	public E get(Connection connection, String sql, Object[] arr, Mapper<E> mapper) {
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
				object = mapper.extract(rs);
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

	public void update(Connection connection, String sql, Object[] arr) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < arr.length; i++) {
				ps.setObject(i + 1, arr[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			LOG.error("Cannot update object!", e);
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
			LOG.error("Cannot create user!", e);
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
