package com.library.management.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.library.management" })
public class WebMvcConfig implements WebMvcConfigurer {
	@Autowired
	CloseableHttpClient httpClient;
	 
	private static String apiHost = "http://localhost:8081/libraryService";
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
	}
	 
	@Bean
	public RestTemplate restTemplate() {
	RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
	restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(apiHost));
	return restTemplate;
	}
	 
	@Bean
	public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
	HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
	= new HttpComponentsClientHttpRequestFactory();
	clientHttpRequestFactory.setHttpClient(httpClient);
	return clientHttpRequestFactory;
	}
}
