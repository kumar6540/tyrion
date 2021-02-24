package com.customer.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.customer.*"})
@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
public class ServletConfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment ev;
	
	Logger log = Logger.getLogger(ServletConfig.class.getName());

	@Bean
	public InternalResourceViewResolver getViewResolver() {

		InternalResourceViewResolver rv = new InternalResourceViewResolver();
		rv.setPrefix("/WEB-INF/");
		rv.setSuffix(".jsp");
		return rv;
	}

	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sessionfactory = new LocalSessionFactoryBean();
		sessionfactory.setDataSource((javax.sql.DataSource) dataSource());
		sessionfactory.setPackagesToScan(new String[] {"com.customer"});
		sessionfactory.setHibernateProperties(hibernateProperties());
		
		return sessionfactory;
		
	}
	
	
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource ds =  new DriverManagerDataSource();
		ds.setDriverClassName(ev.getProperty("jdbc.driverClassName"));
		ds.setUrl(ev.getProperty("jdbc.url"));
		ds.setUsername(ev.getProperty("jdbc.username"));
		ds.setPassword(ev.getProperty("jdbc.password"));
		return (DataSource) ds;
	}
	
	@Bean
	public Properties hibernateProperties() {
		Properties p = new Properties();
		
		p.put("hibernate.dialect", ev.getProperty("hibernate.dialect"));
		p.put("hibernate.packagesToScan", ev.getProperty("hibernate.packagesToScan"));
		p.put("hibernate.show_sql", ev.getProperty("hibernate.show_sql"));
		p.put("hibernate.connection.pool_size", ev.getProperty("hibernate.connection.pool_size"));
		p.put("hbm2ddl.auto", ev.getProperty("hbm2ddl.auto"));
		p.put("hibernate.packagesToScan", ev.getProperty("hibernate.packagesToScan"));
		return p;
		
	}
	
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		
		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(sessionFactory().getObject());
		
		return manager;

}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/CSS/**").addResourceLocations("/CSS/");
    }
}