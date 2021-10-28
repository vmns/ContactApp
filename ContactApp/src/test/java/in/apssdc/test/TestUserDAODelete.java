package in.apssdc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.apssdc.config.SpringRootConfig;
import in.apssdc.dao.UserDAO;

public class TestUserDAODelete {
public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
	UserDAO userdao = ctx.getBean(UserDAO.class);
	userdao.delete(2);
	System.out.println("----------user deleted------------------");
}

}
