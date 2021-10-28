package in.apssdc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import in.apssdc.entity.User;
@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO{

	@Override
	public void save(User u) {
		// prepare a query
		String sql = "INSERT INTO CAPP_USER(name,phone,email,address,loginName,password,role,loginStatus)"
				+"VALUES(:name,:phone,:email,:address,:loginName,:password,:role,:loginStatus)";
		// user data will be generated from registration form
		// mapping the data(getting data from user object)
		Map m = new HashMap();
		m.put("name",u.getName());
		m.put("phone",u.getPhone());
		m.put("email",u.getEmail());
		m.put("address",u.getAddress());
		m.put("loginName",u.getLoginName());
		m.put("password",u.getPassword());
		m.put("role",u.getRole());
		m.put("loginStatus",u.getLoginStatus());
		// Getting key from the database
		KeyHolder kh = new GeneratedKeyHolder();
		// binding the data
		SqlParameterSource ps = new MapSqlParameterSource(m);
		//execute the query
		super.getNamedParameterJdbcTemplate().update(sql,ps,kh);
		Integer userId = kh.getKey().intValue();
		u.setUserId(userId);
		
	}

	@Override
	public void update(User u) {
		String sql = "UPDATE CAPP_USER SET "
				+"name=:name,"
				+"phone=:phone,"
				+"email=:email,"
				+"address=:address,"
				+"role=:role,"
				+"loginStatus=:loginStatus"
				+" WHERE userId=:userId";
		Map m = new HashMap();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());
		m.put("userId", u.getUserId());
		getNamedParameterJdbcTemplate().update(sql,m);
		
	}

	@Override
	public void delete(User u) {
		Integer userId = u.getUserId();
		this.delete(userId);
		
	}

	@Override
	public void delete(Integer userId) {
		String sql="DELETE FROM CAPP_USER WHERE userId=?";
		getJdbcTemplate().update(sql,userId);
		
	}

	@Override
	public void findById(Integer userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> finAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByProperty(String propertyName, Object propValue) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
