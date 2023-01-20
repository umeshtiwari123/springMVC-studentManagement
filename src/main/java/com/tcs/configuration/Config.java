package com.tcs.configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.tcs" })
public class Config {

	@Bean(name = "emf1")
	@Scope(value = "prototype")
	public EntityManagerFactory getEMF() {
		return Persistence.createEntityManagerFactory("pwdManage");
	}
}
