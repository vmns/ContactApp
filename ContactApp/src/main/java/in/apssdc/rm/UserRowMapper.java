package in.apssdc.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.apssdc.entity.User;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u = new User();
		u.setUserId(rs.getInt("userId"));
		u.setName(rs.getString("name"));
		u.setEmail(rs.getString("email"));
		u.setAddress(rs.getString("address"));
		u.setLoginName(rs.getString("loginName"));
		u.setLoginStatus(rs.getInt("loginStatus"));
		u.setPhone(rs.getString("phone"));
		u.setRole(rs.getInt("role"));
		
		return u;
	}

}
