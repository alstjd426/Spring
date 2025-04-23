package com.Lect.week04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.Lect.week03.SmsSender;
import com.Lect.week03.workUnit;

@Configuration
public class BeanScopeConfig {
	@Bean(name = "scopeBean0")
	public SmsSender singletonBean() {
		return new SmsSender();
	}
	
	@Bean(name = "scopeBean1")
	@Scope("prototype")
	public SmsSender prototypeBean() {
		return new SmsSender();
	}
	
	@Bean(name = "scopeBean2")
	@RequestScope
	public SmsSender requestBean() {
		return new SmsSender();
	}
	
	@Bean(name = "scopeBean3")
	@SessionScope
	public SmsSender sessionScopeBean() {
		return new SmsSender();
	}
	
	@Autowired
	private WorkUnit[] prototypeBean; 
	
	@Bean   
	public WorkUnit[] useDifferentScope() {
		return prototypeBean;
	}
	
	@Autowired
	private ObjectFactory<WorkUnit[]> prototypeBeanFactory;
	@Bean
	public ObjectFactory<WorkUnit[]> objectFactoryBean(){
		return prototypeBeanFactory;
	}
	
}
