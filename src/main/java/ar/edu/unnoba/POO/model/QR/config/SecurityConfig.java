package ar.edu.unnoba.POO.model.QR.config;

import ar.edu.unnoba.POO.model.QR.service.GestorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@Order(2)
public class SecurityConfig {



    private GestorServiceImp GestorDetailsService;

    @Autowired
    public SecurityConfig(GestorServiceImp userDetailsService) {
        this.GestorDetailsService = userDetailsService;
    }




    public UserDetailsService getUserDetailsService() {
        return GestorDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .userDetailsService(GestorDetailsService)
                .authorizeHttpRequests((requests) -> requests
                        .antMatchers( "/webjars/**","/resources/**","/css/**").permitAll()
                        .antMatchers("/").permitAll()
                        .anyRequest().authenticated()

                )

                .formLogin((form) -> form
                        //.loginPage("/login")
                        .loginPage("/home")
                        .loginProcessingUrl("/login")
                        .usernameParameter("email")
                        .defaultSuccessUrl("/gestor/home")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        return this.GestorDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(GestorDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;


    }
}
