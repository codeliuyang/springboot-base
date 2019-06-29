package com.lerr.demo.config;

import com.lerr.demo.filter.JwtAuthenticationFilter;
import com.lerr.demo.filter.JwtLoginFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SpringSecurity 配置
 *
 * @auther: yangliu
 * create date: 08-06-2019
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${security.filter.url}")
    private String securityFilterUrl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors().and()
                .authorizeRequests()
                .antMatchers(securityFilterUrl,
                        "/index.html",
                        "/swagger-ui.html",
                        "/swagger-ui.html/**",
                        "/swagger-resources/**",
                        "**swagger**",
                        "/v2/api-docs",
                        "/webjars/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtLoginFilter(authenticationManager()))
                .addFilter(new JwtAuthenticationFilter(authenticationManager()));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
