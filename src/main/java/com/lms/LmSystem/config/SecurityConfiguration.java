/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.LmSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

/**
 *
 * @author mocha
 */
@Configuration
public class SecurityConfiguration {
    @Primary
    @Bean
    
     public FreeMarkerConfigurationFactoryBean factoryBean(){
        FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
        bean.setTemplateLoaderPaths("classpath:/templates/mail");
        return bean;
    }
}
