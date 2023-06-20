package resources;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import biblioteca.dao.DaoSession;



@Configuration
public class ConfigDaoSession {
	

	@Bean(initMethod="initDaoSession", destroyMethod="destroyDaoSession")
	@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public DaoSession nuevoDaoSession() {

		return new DaoSession();
	}
	
	
}
