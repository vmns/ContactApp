package in.apssdc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.apssdc.dao.BaseDAO;
import in.apssdc.dao.UserDAO;
import in.apssdc.entity.User;
import in.apssdc.exception.UserBlockedException;
@Service
public class UserServiceImpl extends BaseDAO implements UserService{
	@Autowired
	private UserDAO userdao;
	@Override
	public void register(User u) {
		userdao.save(u);
	}

	@Override
	public User login(String loginName, String pwd) throws UserBlockedException {
		// TODO Auto-generated method stub
		return null;
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
