package io.can.usergallery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.can.usergallery.interceptor.RequestHandlerInterceptor;

@Configuration
public class RequestHandlerConfig implements WebMvcConfigurer{

	@Autowired
	private RequestHandlerInterceptor requestHandlerInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestHandlerInterceptor);
	}
	
}
