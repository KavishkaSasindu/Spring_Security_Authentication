package com.example.SpringSecurityAuthentication.config;

import com.example.SpringSecurityAuthentication.service.MyUserDetailService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Data
@Configuration
@EnableWebSecurity
@NoArgsConstructor
public class SecurityConfig {

    private MyUserDetailService myUserDetailService;

    @Autowired
    public SecurityConfig(MyUserDetailService myUserDetailService) {
        this.myUserDetailService = myUserDetailService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(myUserDetailService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http.csrf(customizer->customizer.disable());
        http.httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(request->request.anyRequest().authenticated());
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }


}
