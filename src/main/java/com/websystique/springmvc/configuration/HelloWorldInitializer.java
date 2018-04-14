package com.websystique.springmvc.configuration;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HelloWorldInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	//@Autowired
	//private Environment environment;
	@Value("location.path")
	String location;

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { HelloWorldConfiguration.class };
	}
 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}
 
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

    @Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
    	registration.setMultipartConfig(getMultipartConfigElement());
	}

    private MultipartConfigElement getMultipartConfigElement(){
		//String location=environment.getProperty("hibernate.hbm2ddl.auto");
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(location, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
		return multipartConfigElement;
	}
    
    /*Set these variables for your project needs*/ 

	private static final long MAX_FILE_SIZE = 1024 * 1024 * 25;//25MB
	
	private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 30;//30MB

    private static final int FILE_SIZE_THRESHOLD = 0;
}
