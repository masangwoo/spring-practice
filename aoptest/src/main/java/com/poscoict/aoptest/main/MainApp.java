package com.poscoict.aoptest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.poscoict.aoptest.service.ProductService;
import com.poscoict.aoptest.vo.ProductVo;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("config/applicationContext.xml");
				
		ProductService ps = ac.getBean(ProductService.class);
		System.out.println(ps);
		ProductVo vo = ps.find("TV");
		System.out.println(vo);
		
		((AbstractApplicationContext)ac).close();
		
	}

}
