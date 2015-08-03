package ua.nure.zhabin.SummaryTask4.db;

import java.util.List;

public class Parameter {

	private String sql;
	private List<Object> params;
	
	public Parameter(String sql, List<Object> params) {
		this.sql = sql;
		this.params = params;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public List<Object> getParams() {
		return params;
	}

	public void setParams(List<Object> params) {
		this.params = params;
	}	
}
