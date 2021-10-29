package in.apssdc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.apssdc.config.SpringRootConfig;
import in.apssdc.dao.UserDAO;
import in.apssdc.entity.User;

public class TestUserFindById {
public static void main(String[] args) {
	
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
	UserDAO userdao = ctx.getBean(UserDAO.class);
	User u = userdao.findById(1);
	System.out.println(u.getAddress());
	System.out.println(u.getEmail());
	System.out.println(u.getLoginName());
	System.out.println(u.getName());
	System.out.println(u.getPassword());
	System.out.println(u.getPhone());
	System.out.println(u.getLoginStatus());
	System.out.println(u.getUserId());
	
}
}
