package com.order.config;

import java.util.Locale;
import java.util.Properties;

import javax.sql.DataSource;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.order.formatter.Phoneformatter;

@EnableWebMvc
@Configuration
@ComponentScan("com.order.*")
@PropertySource("classpath:email.properties")
@WebAppConfiguration
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
	public MessageSource messageSource() {
		ResourceBundleMessageSource msg = new ResourceBundleMessageSource();
		msg.setBasenames("Appmessages");

		return msg;

	}

	public LocalValidatorFactoryBean validator(){

		LocalValidatorFactoryBean lv = new LocalValidatorFactoryBean();
		lv.setValidationMessageSource(messageSource());


		return lv;

	}

	@Override
	public Validator getValidator() {

		return validator();
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {

		System.out.println("Inside Formatter Config");

		registry.addFormatter(new Phoneformatter());
	}

	@Bean
	public JavaMailSenderImpl getJavaMailSender() {
		
	//	System.out.println(ev.getProperty("mail.host"));
		log.info(">>>>>>>>>>fetching the host value: "+ ev.getProperty("mail.host"));
		
		JavaMailSenderImpl javamailsenderimp = new JavaMailSenderImpl();
		javamailsenderimp.setHost(ev.getProperty("mail.host"));
		javamailsenderimp.setUsername(ev.getProperty("mail.username"));
		javamailsenderimp.setPassword(ev.getProperty("mail.password"));
		javamailsenderimp.setPort(Integer.parseInt(ev.getProperty("mail.port")));
		
		
		javamailsenderimp.setJavaMailProperties(getMailProperties());
		return javamailsenderimp;
		
	}
	private Properties getMailProperties() {
		Properties mailproperties = new Properties();
		mailproperties.put("mail.smtp.starttls.enable", true);
		mailproperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		return mailproperties;
	}
	
	@Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.ENGLISH);
        return slr;
    }

	@Bean("dataSource")
	public DataSource dataSource() {
		
		 String url ="jdbc:mysql://localhost/college";
			String user="root";
			String password = "123456789";
		DriverManagerDataSource ds =  new DriverManagerDataSource(url,user,password);
		ds.setDriverClassName("com.mysql.jdbc.Driver");
	
		//ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return ds;
		
	}
	
	@Bean
	public JdbcTemplate JdbcTemplate() {
		 JdbcTemplate jdbcTemplate = new JdbcTemplate();
	       jdbcTemplate.setDataSource(dataSource());
		 jdbcTemplate.setResultsMapCaseInsensitive(true);
	        return jdbcTemplate;
		
	}


}
