package in.apssdc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.apssdc.config.SpringRootConfig;
import in.apssdc.entity.Contact;
import in.apssdc.service.ContactService;

public class TestContactServiceSave {
public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
	ContactService contactService = ctx.getBean(ContactService.class);
	Contact c = new Contact();
	c.setName("xyz");
	c.setAddress("anantapur");
	c.setEmail("xyz@gmail.com");
	c.setPhone("9726231234");
	c.setRemarks("bai");
	c.setUserId(2);
	contactService.save(c);
	System.out.println("-------------user data saved successfully-----------------");
}
}
