package com.example.hello.spring;

import com.example.hello.spring.filters.HelloFilter;
import com.example.hello.spring.listener.HelloListener;
import com.example.hello.spring.servlet.HelloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

// http://www.techmentro.com -- udacity go quiz here

@SpringBootApplication
// @ServletComponentScan
public class HelloSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        ServletRegistrationBean servletBean = new ServletRegistrationBean<>(new HelloServlet());
        servletBean.addUrlMappings("/helloServlet");
        return servletBean;
    }

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean filterBean = new FilterRegistrationBean<>(new HelloFilter());
        // Add filter path
        filterBean.addUrlPatterns("/helloServlet");
        return filterBean;
    }

    @Bean
    public ServletListenerRegistrationBean getServletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>(new HelloListener());
    }

}
