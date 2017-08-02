package com.wshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@EnableWebMvc
public class CustomWebMvcAutoAdapter extends WebMvcConfigurerAdapter {

//	@Bean
//    public LocaleResolver localeResolver() {
//        SessionLocaleResolver slr = new SessionLocaleResolver();
//        slr.setDefaultLocale(Locale.ENGLISH);
//        return slr;
//    }
//
//    @Bean
//    public ReloadableResourceBundleMessageSource messageSource() {
//    	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//    	messageSource.setBasename("classpath:locale/messages");
//    	messageSource.setCacheSeconds(3600);
//    	messageSource.setDefaultEncoding("UTF-8");
//    	return messageSource;
//    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");

    }


}
