package com.Lect.week04;

public class InitDestroyUnit {
	@PostConstruct
	public void postConstruct() {
		System.out.println("InitDestroyUnit 초기화(@PostConstruct) 메서드 실행");
	}
	
	@PreDestroy
	public void PreDestroy() {
		System.out.println("InitDestroyUnit 초기화(@PostConstruct) 메서드");
	}
}
