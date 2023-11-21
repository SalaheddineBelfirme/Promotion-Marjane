package com.youcode.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@ComponentScan(basePackages = {"com.youcode"})
@EnableWebMvc
@EnableJpaRepositories(basePackages = {"com.youcode.repositories"})
public class AppConfig implements WebMvcConfigurer {
    // Response Parsing Configuration
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new org.springframework.http.converter.json.MappingJackson2HttpMessageConverter());
    }
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }

    // Persistence Configuration
    @Bean
    EntityManagerFactory entityManagerFactory(){
        return Persistence.createEntityManagerFactory("default");
    }

    @Bean
    public EntityManager createEntityManager()
    {
        return entityManagerFactory().createEntityManager();
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory);
        return manager;
    }
}
