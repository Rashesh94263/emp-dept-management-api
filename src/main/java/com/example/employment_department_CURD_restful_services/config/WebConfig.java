package com.example.employment_department_CURD_restful_services.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@Configuration
@EnableWebMvc

public class WebConfig implements WebMvcConfigurer {


    @Bean
    public WebMvcConfigurer corsConfigure() {

        return new WebMvcConfigurer() {


            @Override
            public void addCorsMappings(CorsRegistry registry) {

                 registry.addMapping("/**")
                                .allowedOrigins("http://localhost:5173")
                                .allowedMethods("GET", "POST", "PUT", "DELETE")
                                .allowedHeaders("*")
                                .allowCredentials(true);

                WebMvcConfigurer.super.addCorsMappings(registry);
            }
        };
    }
    /*
    @Bean
    @CrossOrigin(value = "http://localhost:5173",allowedHeaders = "*", allowCredentials = "true", methods = {"GET","POST","PUT","DELETE"})
    public WebMvcConfigurer corsConfigure(){

        /*
        return new WebMvcConfigurer(){

            public void addCorsMapping(CorsRegistry registry){

                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }*/

}
