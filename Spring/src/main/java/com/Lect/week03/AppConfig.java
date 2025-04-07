package com.Lect.week03;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public SmsSender configSms() {
		return new SmsSender();
	}

	@Bean
	public List<String> unit() {
		List<String> list = new ArrayList();
		
		list.add("문자열 1");
		list.add("문자열 2");
		return list;
	}
}
