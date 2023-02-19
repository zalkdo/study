package com.example.restfulwebservice.config;


import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//@EnableSwagger2
@Configuration
public class SwaggerConfig {

//    private final String baseUrl;
//
//    public SwaggerConfig(String baseUrl){
//        this.baseUrl = baseUrl;
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry
//            .addResourceHandler(baseUrl+"/swagger-ui/**")
//            .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
//            .resourceChain(false);
//    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry){
//        registry
//                .addViewController(baseUrl+"/swagger-ui/**")
//                .setViewName("forward:"+baseUrl+"/swagger-ui/index.html");
//    }

    private static final Contact DEFAULT_CONTACT = new Contact("greate Kim",
            "http://www.gk.co.kr",
            "gk@emro.co.kr");

    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "API Title",
            "My User management REST API service",
            "1.0",
            "urn:tos",
            DEFAULT_CONTACT,
            "Apache 2.0",
            "http://www.apche.org/licenses/LICENSE-2.0",
            new ArrayList<>());

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(
            Arrays.asList("application/json", "application/xml")
    );

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}
