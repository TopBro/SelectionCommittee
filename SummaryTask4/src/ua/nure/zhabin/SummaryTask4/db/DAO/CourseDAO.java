package ua.nure.zhabin.SummaryTask4.db.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.nure.zhabin.SummaryTask4.db.entity.Course;

public interface CourseDAO {
	
	public int insertCourse();
	public boolean deleteCourse();	
	public boolean updateCourse();	
	public List<Course> findCourses();
	public List<Course> findCourses(int topicId);
	public List<Course> findCourses(int statusId, int userId, int mark);
	public Course extractCourse(ResultSet rs) throws SQLException;
}
