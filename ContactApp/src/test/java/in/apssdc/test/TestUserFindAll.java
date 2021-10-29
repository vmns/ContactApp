package in.apssdc.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.apssdc.config.SpringRootConfig;
import in.apssdc.dao.UserDAO;
import in.apssdc.entity.User;

public class TestUserFindAll {
public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
	UserDAO userdao = ctx.getBean(UserDAO.class);
	List<User> users = userdao.finAll();
	for(User u: users) {
		System.out.println(u.getUserId()+" "+u.getName()+" "+u.getEmail()+" "+u.getAddress()+" "+u.getLoginName()+" "+u.getPhone()+" "+u.getRole());
	}
}
}
