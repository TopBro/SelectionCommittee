package ua.nure.zhabin.SummaryTask4.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.nure.zhabin.SummaryTask4.db.entity.Faculty;

public interface FacultyDAO {
	
	public int insertCourse();
	public boolean deleteCourse();	
	public boolean updateCourse();	
	public List<Faculty> findCourses();
	public List<Faculty> findCourses(int topicId);
	public List<Faculty> findCourses(int statusId, int userId, int mark);
	public Faculty extractCourse(ResultSet rs) throws SQLException;
}
