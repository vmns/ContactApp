package in.apssdc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import in.apssdc.entity.Contact;
@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO{

	@Override
	public void save(Contact c) {
		//prepare a query
		String sql = "INSERT INTO capp_contact(userId,name,phone,email,address,remarks) "
				+"VALUES(:userId,:name,:phone,:email,:address,:remarks)";
		Map m = new HashMap();
		m.put("userId",c.getUserId());
		m.put("name", c.getName());
		m.put("phone",c.getPhone());
		m.put("email",c.getEmail() );
		m.put("address",c.getAddress());
		m.put("remarks",c.getRemarks());
		SqlParameterSource ps = new MapSqlParameterSource(m);
		KeyHolder kh = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(sql,ps,kh);
		c.setContactId(kh.getKey().intValue());
	}

	@Override
	public void update(Contact c) {
		String sql = "UPDATE capp_contact SET name=:name,phone=:phone,email=:email,"
				+"address=:address,remarks=:remarks WHERE contactId=:contactId";
		Map m = new HashMap();
		m.put("contactId",c.getContactId());
		m.put("name", c.getName());
		m.put("phone",c.getPhone());
		m.put("email",c.getEmail());
		m.put("address",c.getAddress());
		m.put("remarks",c.getRemarks());
		getNamedParameterJdbcTemplate().update(sql,m);
		
	}

	@Override
	public void delete(Contact c) {
		this.delete(c.getContactId());
		
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM capp_contact WHERE contactId=?";
		getJdbcTemplate().update(sql,id);
		
	}

	@Override
	public void findById(Integer cid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> findByProperty(String proName, Object propValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
