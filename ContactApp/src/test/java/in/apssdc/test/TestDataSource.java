package in.apssdc.test;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.apssdc.config.SpringRootConfig;

public class TestDataSource {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		DataSource ds = ctx.getBean(DataSource.class);// got datasource object
		JdbcTemplate jt = new JdbcTemplate(ds);
		//Creating  query
		String sql = "INSERT INTO CAPP_USER(name,phone,email,address,loginname,password) VALUES(?,?,?,?,?,?)";
		Object[] param = new Object[] {"sekhar","7306649482","sekhar939@gmail.com","Dhone","SN","NS001"};
		jt.update(sql,param);
		System.out.println("-----------------SQl QUERY EXECUTED------------------");
		
		
		
	}
}
