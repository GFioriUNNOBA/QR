package ar.edu.unnoba.POO.model.QR.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by jpgm on 31/10/22.
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/gestor/home").setViewName("gestor/home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/admin/login").setViewName("admin/login");
        registry.addViewController("/gestor/productos/index").setViewName("gestor/productos/index");
        registry.addViewController("/gestor/productos/qr").setViewName("gestor/productos/QrDelProducto");

    }
}
