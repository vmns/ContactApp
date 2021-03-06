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
		u.setName("vamsi");
		u.setAddress("anantapur");
		u.setEmail("vamsi@gmail.com");
		u.setPhone("972624234");
		u.setPassword("321");
		u.setRole(2);
		u.setLoginName("vamsi");
		u.setLoginStatus(2);
		userdao.save(u);
		System.out.println("-------------user data saved successfully-----------------");
		
	}
}///ContactApp
