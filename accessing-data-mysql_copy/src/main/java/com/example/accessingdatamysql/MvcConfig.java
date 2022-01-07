package com.example.accessingdatamysql;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/form").setViewName("Form");
		registry.addViewController("/ddd").setViewName("ddd");
		//registry.addViewController("/").setViewName("index");
		//registry.addViewController("/Update").setViewName("Update");
		//registry.addViewController("/index").setViewName("index");
		// registry.addViewController("/login").setViewName("login");
	}

}