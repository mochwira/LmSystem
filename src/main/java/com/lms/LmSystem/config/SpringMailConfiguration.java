/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.LmSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author mocha
 */
@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class SpringMailConfiguration extends WebSecurityConfigurerAdapter {
    
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService); //To change body of generated methods, choose Tools | Templates.
    }

    @Override //mengatur map kemana
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("role").hasRole("admin")
                //.antMatchers("/role").hasRole("admin")
                .antMatchers("home/").hasRole("user")
                .antMatchers("/").permitAll()
                .antMatchers("/password/forgot").permitAll()
                .antMatchers("/password/forgot/request").permitAll()
                .and()
                .formLogin()
//                .loginPage("/loginpage")
//                .successHandler(csh)
//                .usernameParameter("email").passwordParameter("password")
                ;
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
