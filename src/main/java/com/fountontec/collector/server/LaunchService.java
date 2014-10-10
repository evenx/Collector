package com.fountontec.collector.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author wenyi
 *
 */
public class LaunchService 
{
	
    public static void main( String[] args )
    {
		new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
