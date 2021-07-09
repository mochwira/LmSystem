/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.LmSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

/**
 *
 * @author mocha
 */
@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService); //To change body of generated methods, choose Tools | Templates.
    }

    @Override //mengatur map kemana
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("user").hasRole("admin")
//                //.antMatchers("/role").hasRole("admin")
//                .antMatchers("home/").hasRole("user")
//                .antMatchers("/").permitAll()
//                .antMatchers("/password/forgot").permitAll()
//                .antMatchers("/password/forgot/request").permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/loginpage")
//                .successHandler(csh)
//                .usernameParameter("email").passwordParameter("password")

                .antMatchers("/artikel").hasRole("admin")
                .antMatchers("/product").hasAnyRole("admin", "employee", "publisher")
                .antMatchers("/user").hasRole("admin")
                .antMatchers("/role").hasRole("admin")
                .antMatchers("/kategori").hasRole("admin")
                .antMatchers("/user").hasRole("admin")
                .antMatchers("/home").hasRole("employee")
                .antMatchers("/approval").hasRole("publisher")
                .antMatchers("/file").hasRole("publisher")
                //.antMatchers("/").permitAll()
                //.antMatchers("/artikel").permitAll()
                .antMatchers("/password/forgot").permitAll()
                .antMatchers(HttpMethod.POST, "/password/forgot/request").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                //.successHandler(customSuccessHandler)
                .usernameParameter("email")
                .passwordParameter("password")
                //.failureUrl("/department")
                .permitAll()
                .and().csrf()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accsess_denied")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                //.addLogoutHandler(new SecurityLogout())
                .logoutSuccessUrl("/artikel");
        ;
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
