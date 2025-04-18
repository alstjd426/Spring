package com.Lect.week04;

@Component
public class AwareInterfaceImp implements BeanNameAware, ApplicationContextAware{
	private ApplicationContext context;

	public ApplicationContext getContext() {
		return context;
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		System.out.println("setApplicationContext() 메서드 실행");
		this.context = applicationContext;
		System.out.println("컨테이너 : " + this.context.getId());
	}
	@Override
	public void setBeanName(String name) {
		System.out.println("setBeanName() 메서드 실행");
		System.out.println("해당 빈 이름 : " + name);
		System.out.println("================");
	}
	
	
	
	
}
