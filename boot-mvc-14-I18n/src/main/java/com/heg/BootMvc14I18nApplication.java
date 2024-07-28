package com.heg;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvc14I18nApplication {

	@Bean("messageSource")
	public ResourceBundleMessageSource createRBMS() {
		ResourceBundleMessageSource source= new ResourceBundleMessageSource();
		source.setBasename("com/heg/commons/App");
		return source;
	}
	
	@Bean("localeResolver")
	public SessionLocaleResolver createSLResolver() {
		
		SessionLocaleResolver resolver= new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en","US"));
		return resolver;
	}
	
	@Bean("lci")
	public LocaleChangeInterceptor createLocaleInterceter() {
		LocaleChangeInterceptor interceptor= new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvc14I18nApplication.class, args);
	}

}
