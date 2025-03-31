package com.Lect.week03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContextController {
	private XmlWebApplicationContext xmlContext;
	AnnotationConfigWebApplicationContext configContext;
	ModelAndView mav;
	
	public ContextController() {
		super();
		xmlContext = new XmlWebApplicationContext();
		configContext = new AnnotationConfigWebApplicationContext();
		mav = new ModelAndView();
	}
	@GetMapping("/createBean")
	public ModelAndView beanTest() {
		xmlContext.setConfigLocation("classpath:static/xml/Ex1.xml");
		xmlContext.refresh();
		SmsSender xmlSms = (SmsSender)xmlContext.getBean("xmlSms");
		
		configContext.register(AppConfig.class);
		configContext.refresh();
		
		SmsSender configSms = (SmsSender)configContext.getBean("configSms");
		
		mav.setViewName("week03/beanView");
		mav.addObject("xmlSms", xmlSms);
		mav.addObject("configSms", configSms);
		
		return mav;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
