package in.apssdc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.apssdc.config.SpringRootConfig;
import in.apssdc.dao.UserDAO;
import in.apssdc.entity.User;

public class TestUserDAOSave {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userdao = ctx.getBean(UserDAO.class);
		User u = new User();
		u.setName("raju");
		u.setAddress("kurnool");
		u.setEmail("raju@gmail.com");
		u.setPhone("1238934234");
		u.setPassword("123");
		u.setRole(1);
		u.setLoginName("raj");
		u.setLoginStatus(1);
		userdao.save(u);
		System.out.println("-------------user data saved successfully-----------------");
		
	}
}///ContactApp
