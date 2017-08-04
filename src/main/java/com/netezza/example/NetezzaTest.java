package com.netezza.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netezza.dao.NetezzaDao;

public class NetezzaTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        NetezzaDao netezzaDao = (NetezzaDao) context.getBean("netezzaDao");
        
        int numOfSignals = netezzaDao.getNumOfSignals();
        System.out.println("number of mo signals is: " + numOfSignals);
        
	}
}
