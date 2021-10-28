package in.apssdc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.apssdc.config.SpringRootConfig;
import in.apssdc.dao.UserDAO;
import in.apssdc.entity.User;

public class TestUserDAOUpdate {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userdao = ctx.getBean(UserDAO.class);
		User u = new User();
		u.setName("raj kumar");
		u.setAddress("Nandyal");
		u.setEmail("rajkumar@gmail.com");
		u.setPhone("987654321");
		//u.setPassword("123");
		u.setRole(1);
		//u.setLoginName("raj");
		u.setLoginStatus(2);
		u.setUserId(4);
		userdao.update(u);
		System.out.println("-------------user data saved successfully-----------------");
		
	}
}///ContactApp
