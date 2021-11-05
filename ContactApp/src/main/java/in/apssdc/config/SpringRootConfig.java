package in.apssdc.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"in.apssdc.service","in.apssdc.dao"})
public class SpringRootConfig {    
    //TODO: Services, DAO, DataSource, Email Sender or some other business layer beans   
   @Bean
   public BasicDataSource getDataSource()
   {
	   BasicDataSource ds = new BasicDataSource();
	   ds.setDriverClassName("com.mysql.jdbc.Driver");
	   ds.setUrl("jdbc:mysql://localhost:3306/capp");
	   ds.setUsername("root");
	   ds.setPassword("root");
	   ds.setMaxTotal(2); // number of connections
	   ds.setInitialSize(1);
	   ds.setTestOnBorrow(true);
	   ds.setValidationQuery("SELECT 1");
	   ds.setDefaultAutoCommit(true);
	   return ds;
   }
}
