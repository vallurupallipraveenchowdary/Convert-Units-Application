package com.praveen.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.praveen.logger.ApiLogger;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	 @Autowired
	    private ApiLogger apiLogger;

	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(apiLogger)
	                .addPathPatterns("/**");
	    }

}
