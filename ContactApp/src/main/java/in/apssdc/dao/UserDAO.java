package in.apssdc.dao;

import java.util.List;

import in.apssdc.entity.User;

public interface UserDAO {

	public void save(User u); // save the user
	public void update(User u); // update the user
	public void delete(User u); // delete the user
	public void delete(Integer userId);// delete the specified user using (userId)
	public User findById(Integer userId); // accessing the user based on id
	public List<User> finAll(); // accessing all the users
	public List<User> findByProperty(String propertyName, Object propValue); //based on columnname we get the data
	
	
}
