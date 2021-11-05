package in.apssdc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.apssdc.config.SpringRootConfig;
import in.apssdc.entity.User;
import in.apssdc.service.UserService;

public class TestUserServiceRegister {
public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
	UserService userService = ctx.getBean(UserService.class);
	User u = new User();
	u.setName("Nagasekhar");
	u.setAddress("kurnool");
	u.setEmail("sekharnaga@gmail.com");
	u.setPhone("987672834");
	u.setPassword("password");
	u.setRole(UserService.ROLE_ADMIN);
	u.setLoginName("sekhar");
	u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
	userService.register(u);
	System.out.println("-------------user data saved successfully using service method-----------------");
}
}
