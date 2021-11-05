package in.apssdc.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.apssdc.entity.Contact;

public class ContactRowMapper implements RowMapper<Contact>{

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact c = new Contact();
		c.setUserId(rs.getInt("userId"));
		c.setName(rs.getString("name"));
		c.setEmail(rs.getString("email"));
		c.setAddress(rs.getString("address"));
		c.setPhone(rs.getString("phone"));
		c.setContactId(rs.getInt("contactId"));
		c.setRemarks(rs.getString("remarks"));
		return c;
	}

}
