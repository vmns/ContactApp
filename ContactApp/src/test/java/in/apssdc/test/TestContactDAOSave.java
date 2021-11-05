package in.apssdc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.apssdc.config.SpringRootConfig;
import in.apssdc.dao.ContactDAO;
import in.apssdc.dao.UserDAO;
import in.apssdc.entity.Contact;

public class TestContactDAOSave {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDao = ctx.getBean(ContactDAO.class);
		Contact c = new Contact();
		c.setName("vamsi");
		c.setAddress("anantapur");
		c.setEmail("vamsi@gmail.com");
		c.setPhone("972624234");
		c.setRemarks("hai");
		c.setUserId(2);
		contactDao.save(c);
		System.out.println("-------------user data saved successfully-----------------");
		
	}
}///ContactApp
