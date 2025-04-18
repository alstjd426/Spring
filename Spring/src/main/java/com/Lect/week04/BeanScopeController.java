package com.Lect.week04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import com.Lect.week03.SmsSender;


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
	
	@ResponseBody
	@GetMapping("/post&pre")
	public String customMethod () {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(InitDestroyUnit.class);
		System.out.println("===============");
		context.close();
		return "Console 메시지를 확인하세요.";
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
