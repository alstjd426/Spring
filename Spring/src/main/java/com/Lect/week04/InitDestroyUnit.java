package com.Lect.week04;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class InitDestroyUnit implements InitializingBean, DisposableBean{ //방법1

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy() 메소드 실행");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterPropertiesSet() 메소드 실행");

	}
	@Bean(initMethod = "init", destroyMethod = "cleanup")
	public InitDestroyUnit myBean() {
		return new InitDestroyUnit();
	}
	public void init() {
		System.out.println("InitDestroyUnit	초기화(init) 메소드 실행");

	}
	public void cleanup() {
		System.out.println("InitDestroyUnit	소멸(destroy) 메소드 실행");
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("InitDestroyUnit	초기화(@PostConstruct) 메소드 실행");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("InitDestroyUnit	소멸(@PreDestroy) 메소드 실행");
	}

}
