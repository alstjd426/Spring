package com.Lect.week04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Lect.week03.SmsSender;
import com.Lect.week03.workUnit;

@Controller
public class BeanScopeController {

	@Autowired
	private WebApplicationContext context;
	
	@GetMapping("/scopeBean")
	public ModelAndView scopeBean(ModelAndView mav) {
		SmsSender[][] scopeBeanArray = new SmsSender[4][2];
		for(int i=0; i<4; i++) {
			for(int j=0; i<2; j++)
				scopeBeanArray[i][j] = (SmsSender)context.getBean("scopeBean"+i);
		}
		mav.addObject("scopeBeanArray",scopeBeanArray);
		mav.setViewName("week04/scopeBeanView");
		return mav;
	}
	
	@GetMapping({"/useDifferentScope"})
	public ModelAndView differentScope(ModelAndView mav) {
		
		WorkUnit[][] scopeBeanArray = new WorkUnit[2][1];
		scopeBeanArray[0] = (
				WorkUnit[])context.getBean("useDifferentScope");
		scopeBeanArray[1] = (
				WorkUnit[])context.getBean("useDifferentScope");
		
		mav.addObject("scopeBeanArray", scopeBeanArray);
		mav.setViewName("week04/differentScopeView");
		return mav;
	}
	
	@GetMapping("/objectFactoryBeanTest")
	public ModelAndView objectFactoryTest(ModelAndView mav) {
		
		ObjectFactory<WorkUnit[]> prototypeBeanFactory;
		WorkUnit[][] scopeBeanArray= new WorkUnit[2][1];
		
		prototypeBeanFactory = (ObjectFactory<WorkUnit[]>)
				context.getBean("objectFactoryBean");
		scopeBeanArray[0] = prototypeBeanFactory.getObject(); //ObjectFactory
		
		prototypeBeanFactory = (ObjectFactory<WorkUnit[]>)
				context.getBean("objectFactoryBean");
		scopeBeanArray[1] = prototypeBeanFactory.getObject(); //ObjectFactory
		
		mav.addObject("scopeBeanArray", scopeBeanArray);
		mav.setViewName("week04/differentScopeView");
		
		
		return mav;
	}
	
	@ResponseBody
	@GetMapping("/postpre")
	public String customMethod() {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(InitDestroyUnit.class);
		System.out.println("===========================================");
		context.close();  // 빈객체를 닫음.
		return "Console 출력 메시지를 확인하세요.";
	}
	
	@GetMapping("/awareInterfaceEx")
	public ModelAndView awareInterfaceEx(ModelAndView mav) {
		AwareInterfaceImp awareInterfaceImp = 
				(AwareInterfaceImp)context.getBean("awareInterfaceImp");
		String [] beanName = awareInterfaceImp.getContext()
	}
	@GetMapping("/externalConfigEx")
	public ModelAndView externalConfigEx(ModelAndView mav) {
		externalConfigComponent externalConfigComponent = 
				(ExternalConfigComponent)context.getBean("externalConfigComponent");

		mav.addObject("obj", externalConfigComponent);
		mav.setViewName("week04/externalConfigView");
		
		return mav;
	}
}
