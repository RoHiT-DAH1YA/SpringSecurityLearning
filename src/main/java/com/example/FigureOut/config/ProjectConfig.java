package com.example.FigureOut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProjectConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(c -> c.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers( "/css/**", "/js/**", "/images/**").permitAll()
                        .anyRequest().authenticated()
                )
//                .formLogin(Customizer.withDefaults());
                .formLogin(form -> form
                        .loginPage("/customLoginPage")
                        .defaultSuccessUrl("/welcome", true)
                        .permitAll()
                )
                .logout(l -> l.permitAll());
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        var user = User.withUsername("john")
                .password(passwordEncoder().encode("12345"))
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
