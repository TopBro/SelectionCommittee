package ua.nure.zhabin.SummaryTask4.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ua.nure.zhabin.SummaryTask4.bean.SignupBean;

public interface Mapper<E> {
	
	E extract(ResultSet rs) throws SQLException;
	E extract(SignupBean signupBean);
	
}
