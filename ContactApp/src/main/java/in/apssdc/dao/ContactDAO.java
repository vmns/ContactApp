package in.apssdc.dao;

import java.util.List;

import in.apssdc.entity.Contact;

public interface ContactDAO {

	public void save(Contact c);
	public void update(Contact c);
	public void delete(Contact c);
	public void delete(Integer id);
	public void delete(String name);
	public Contact findById(Integer cid);
	public List<Contact> findAll();
	public List<Contact> findByProperty(String proName,Object propValue);
}
