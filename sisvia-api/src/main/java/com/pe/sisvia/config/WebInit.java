package com.pe.sisvia.config;


import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInit implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebConfig.class);
		ctx.setServletContext(servletContext);
		
		DispatcherServlet dispatcherServlet =  new DispatcherServlet(ctx);
		Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
		servlet.addMapping("/");
		servletContext.addListener(SessionListener.class);
		servlet.setLoadOnStartup(1);
		filterRegistration(servletContext);
		
	}

	private void filterRegistration(final ServletContext servletContext) {
		FilterRegistration corsFilterReq = servletContext.addFilter("CorsFilterReq",CorsFilterReq.class);
		corsFilterReq.addMappingForUrlPatterns(null, false, new String[] { "/*" });
	}
	
}
