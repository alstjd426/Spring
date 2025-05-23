package com.Lect.week03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HardWorkUnit {
	@Autowired
	@Qualifier("configSms")
	private SmsSender autoSms;
	
	
	private workUnit workUnit;
	private String msg;
	
	@Autowired
	public HardWorkUnit(@Qualifier("workUnit")com.Lect.week03.workUnit workUnit) {
		super();
		this.workUnit = workUnit;
	}

	public String getMsg() {
		return msg;
	}

	@Autowired
	@Value("${message.greeting}")
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public workUnit getWorkUnit() {
		return workUnit;
	}

	public SmsSender getAutoSms() {
		return autoSms;
	}
	
}
