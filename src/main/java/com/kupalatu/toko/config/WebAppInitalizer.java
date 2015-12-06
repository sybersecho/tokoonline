package com.kupalatu.toko.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitalizer implements WebApplicationInitializer {
	private static Logger logger = LoggerFactory
			.getLogger(WebAppInitalizer.class);

	public WebAppInitalizer() {
		logger.info("Web App Init created...");
	}

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		logger.info("web init running");
		// root context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(MvcConfig.class);
		rootContext.setServletContext(container);

		// AnnotationConfigWebApplicationContext dispatcherServlet = new
		// AnnotationConfigWebApplicationContext();
		// dispatcherServlet.register(MvcConfig.class);

		ServletRegistration.Dynamic servlet = container.addServlet("dispather",
				new DispatcherServlet(rootContext));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		// container

	}

}
