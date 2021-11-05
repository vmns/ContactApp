package in.apssdc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.apssdc.dao.BaseDAO;
import in.apssdc.dao.ContactDAO;
import in.apssdc.entity.Contact;
import in.apssdc.util.StringUtil;
@Service
public class ContactServiceImpl extends BaseDAO implements ContactService{
	@Autowired
	private ContactDAO contactdao;
	@Override
	public void save(Contact c) {
		contactdao.save(c);
	}

	@Override
	public void update(Contact c) {
		contactdao.update(c);
	}

	@Override
	public void delete(Integer contactId) {
		contactdao.delete(contactId);
	}

	@Override
	public void delete(Integer[] contactIds) {
		// converting array of integer values to comma seperated values
		String ids = StringUtil.tocommaseperatedString(contactIds);
		// prepraing query
		String sql = "delete from capp_contact where contactId in("+ids+")";
		// execute the query
		getJdbcTemplate().update(sql);
	}

	@Override
	public List<Contact> findUserContact(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> findUserContact(Integer userId, String txt) {
		// TODO Auto-generated method stub
		return null;
	}

}
