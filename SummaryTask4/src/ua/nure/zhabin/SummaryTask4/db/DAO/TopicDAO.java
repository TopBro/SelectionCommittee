package ua.nure.zhabin.SummaryTask4.db.DAO;

import java.util.List;

import ua.nure.zhabin.SummaryTask4.db.entity.Topic;

public interface TopicDAO {

	public int insertTopic();
	public boolean deleteTopic();
	public Topic findTopic();
	public boolean updateTopic();	
	public List<Topic> selectTopic();
}
