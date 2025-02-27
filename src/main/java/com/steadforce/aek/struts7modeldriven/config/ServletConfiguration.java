package com.steadforce.aek.struts7modeldriven.config;


import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfiguration {

    @Bean
    FilterRegistrationBean<StrutsPrepareAndExecuteFilter> strutsFilter() {
        final var bean = new FilterRegistrationBean<>(new StrutsPrepareAndExecuteFilter());
        bean.addUrlPatterns("*.action");
        return bean;
    }


}
