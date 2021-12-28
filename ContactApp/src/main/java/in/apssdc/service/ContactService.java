package in.apssdc.service;

import java.util.List;

import in.apssdc.entity.Contact;
import in.apssdc.entity.User;

public interface ContactService {

	public void save(Contact c);
	public void update(Contact c);
	public void delete(Integer contactId);
	public void delete(Integer[] contactIds);
	public List<Contact> findUserContact(Integer userId);
	public List<Contact> findUserContact(Integer userId,String txt);
	public Contact findById(Integer cid);
	
}
