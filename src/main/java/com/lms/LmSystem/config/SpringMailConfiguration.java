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
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

/**
 *
 * @author mocha
 */
@Configuration
public class SpringMailConfiguration {

    @Primary
    @Bean

    public FreeMarkerConfigurationFactoryBean factoryBean(){
        FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
        bean.setTemplateLoaderPaths("classpath:/templates/mail");
        return bean;
    }

}
