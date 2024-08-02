package com.example.crudfs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173/") // Cambia esto por el origen de tu frontend
                .allowedMethods("*") // Permite todos los métodos HTTP (GET, POST, PUT, DELETE, etc.)
                .allowedHeaders("*") // Permite todos los encabezados
                .allowCredentials(true); // Permite el envío de credenciales (cookies, encabezados de autenticación, etc.)
    }
}
