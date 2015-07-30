package ua.nure.zhabin.SummaryTask4.db.DAO;

import java.util.List;

import ua.nure.zhabin.SummaryTask4.db.entity.User;

public interface UserDAO {

	public int insertUser();
	public boolean deleteUser();
	public User findUser();
	public boolean updateUser();	
	public List<User> selectUser();
}
