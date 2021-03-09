package bill.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import formatter.cardformetter;

@Configuration
@EnableWebMvc
@ComponentScan("bill.controller")
public class ServletConfig implements WebMvcConfigurer  {
	
	
	@Bean
	public InternalResourceViewResolver viewresolve() {
		
		System.out.println("View");

		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/");
	    vr.setSuffix(".jsp");
		return vr;
	
	}
	
	/*
	 * public void addFormatters(FormatterRegistry registry) {
	 * 
	 * System.out.println("Card Formatter"); registry.addFormatter(new
	 * cardformetter());
	 * 
	 * 
	 * }
	 * 
	 * 
	 */

}
