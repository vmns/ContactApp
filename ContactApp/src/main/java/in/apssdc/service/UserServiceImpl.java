package in.apssdc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import in.apssdc.dao.BaseDAO;
import in.apssdc.dao.UserDAO;
import in.apssdc.entity.User;
import in.apssdc.exception.UserBlockedException;
import in.apssdc.rm.UserRowMapper;
@Service
public class UserServiceImpl extends BaseDAO implements UserService{
	@Autowired
	private UserDAO userdao;
	@Override
	public void register(User u) {
		userdao.save(u);
	}
	/*
	 * The method handles login operation(authentication) using given credentials. it returns  userobject
	 * when success and null when failed
	 * When user userobject  is blocked an exception will be thrown by this method
	 */ 
	 
	@Override
	public User login(String loginName, String pwd) throws UserBlockedException {
		String sql ="SELECT userId,name,phone,email,address,role,loginStatus,loginName"
				+" From capp_user where loginName=:ln AND password=:pw";
		Map m = new HashMap();
		m.put("ln", loginName);
		m.put("pw",pwd);
		try {
		User user = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());

		if(user.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED))
		{
			throw new UserBlockedException("your account has been blocked! Please contact admin");
		}
		else
		{
			return user;
		}
		}
		catch(EmptyResultDataAccessException e)
		{
			return null;
		}
		
		
		
		
		
		
		
		
		//return user;
		
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		// TODO Auto-generated method stub
		
	}

}
