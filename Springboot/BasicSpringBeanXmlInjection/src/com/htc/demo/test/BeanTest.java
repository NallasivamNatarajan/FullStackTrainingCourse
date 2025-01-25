package com.htc.demo.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.htc.demo.config.BeanConfig;
import com.htc.demo.entity.Employee;

public class BeanTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		ApplicationContext context2 = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		// load from bean xml -> context
		System.out.println("Load Employee form Bean xml file **");
		Employee employee = (Employee) context.getBean("employee1");
		System.out.println(employee.getAddress());
		employee.getAddress().setCity("Delhi");
		System.out.println(employee.getAddress());
		System.out.println(employee);
		
		Employee employee2 = (Employee) context.getBean("employee2");
		System.out.println(employee2.getAddress());
		employee2.getAddress().setCity("Kerala");
		System.out.println(employee2.getAddress());
		System.out.println(employee2);
		
		Employee employee3 = (Employee) context.getBean("employee3");
		System.out.println(employee3.getAddress());
		System.out.println(employee3);
		
		// load from bean config -> context2
		System.out.println();
		System.out.println("Load Employee form Bean config class ##");
		Employee employee4 = (Employee) context2.getBean("employee1");
		System.out.println(employee4.getAddress());
		employee4.getAddress().setCity("Delhi");
		System.out.println(employee4.getAddress());
		System.out.println(employee4);

	}

}
