package com.devonfw.microservice.parking.general.service.impl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.devonfw.module.basic.common.api.config.SpringProfileConstants;

/**
 * Security configuration based on {@link WebSecurityConfigurerAdapter}. This configuration is by purpose designed most
 * simple for two channels of authentication: simple login form and rest-url. (Copied from
 * {@link com.devonfw.microservice.parking.general.service.impl.config.BaseWebSecurityConfig}
 *
 */
@Configuration
@EnableWebSecurity
@Profile(SpringProfileConstants.NOT_JUNIT)
public class WebSecurityConfig extends BaseWebSecurityConfig {

  @Override
  @Autowired
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

  }

  @Override
  public void configure(HttpSecurity httpSecurity) throws Exception {

    httpSecurity.cors().and().csrf().disable(); // Allow postman
    httpSecurity.authorizeRequests().antMatchers("/").permitAll();
  }

}
