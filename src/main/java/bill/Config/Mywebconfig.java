package bill.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Mywebconfig  extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return null;
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] {"/"};
	}

}
