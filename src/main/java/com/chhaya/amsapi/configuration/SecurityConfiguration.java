package com.chhaya.amsapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private CustomBasicAuthenticationEntryPoint customBasicAuthenticationEntryPoint;

    @Autowired
    public void setCustomBasicAuthenticationEntryPoint(CustomBasicAuthenticationEntryPoint customBasicAuthenticationEntryPoint) {
        this.customBasicAuthenticationEntryPoint = customBasicAuthenticationEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .anyRequest().authenticated();

        http.httpBasic()
                .authenticationEntryPoint(customBasicAuthenticationEntryPoint);

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("loco")
                .password("{noop}LOCOhrd12345687")
                .roles("ADMIN");

        auth.inMemoryAuthentication()
                .withUser("locostudents")
                .password("{noop}LOCOstudents12345687")
                .roles("STUDENT");

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v3/api-docs/**",
                "/swagger-ui.html",
                "/swagger-ui/**");
    }

}
