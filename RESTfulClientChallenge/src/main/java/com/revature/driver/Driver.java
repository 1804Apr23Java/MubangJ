package com.revature.driver;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.C_Users;
import com.revature.client.UserClient;


public class Driver {
	public static void main(String[] args) {
		
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		UserClient users = ac.getBean("userClient", UserClient.class);
		
		users.setResourceUrl("http://localhost:8083/Users");
		
		for (C_Users user : users.getUsers()) {
			System.out.println(user);
		}
		
		ac.close();
	}
}
