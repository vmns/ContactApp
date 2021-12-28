package in.apssdc.service;

import java.util.List;

import in.apssdc.entity.User;
import in.apssdc.exception.UserBlockedException;

public interface UserService {
	public static final Integer LOGIN_STATUS_ACTIVE = 1;
	public static final Integer LOGIN_STATUS_BLOCKED = 2;
	public static final Integer ROLE_ADMIN = 1;
	public static final Integer ROLE_USER = 2;
	
	public void register(User u);
	//This methods login operation(authentication) using given credentials,
		//it return userObject when success & null when failed
	public User login(String loginName,String pwd) throws UserBlockedException;
	public List<User> getUserList();
	public void changeLoginStatus(Integer userId,Integer loginStatus);
	
	
}
