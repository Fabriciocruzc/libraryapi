package io.github.fabriciocruzc.libraryapi.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(configurer ->{
                    configurer.loginPage("/login").permitAll();
                })
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(authorize ->{
                    authorize.anyRequest().authenticated();
                })
                .build();
    }
}
