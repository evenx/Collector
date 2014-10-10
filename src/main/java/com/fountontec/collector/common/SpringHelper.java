package com.fountontec.collector.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class SpringHelper implements ApplicationContextAware{

	private static ApplicationContext app;
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringHelper.app = applicationContext;
	}
	
	public static Object getBean(String name){
		return app.getBean(name);
	}

}
