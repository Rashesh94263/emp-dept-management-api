package com.example.employment_department_CURD_restful_services.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



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

}
