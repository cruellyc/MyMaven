package com.lyc.test;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.JmsException;

/**
 *
 * @author liyc
 * @date 2017年8月3日 上午11:34:14
 */
public class SimpleJMSReceiver {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("./conf/activeMqTopicReceive.xml");
		while (true) {
		}
	}

	public void receive(TextMessage message) throws JmsException, JMSException {
		if(message.getStringProperty("phrCode")!=null){
			System.out.println(message.getStringProperty("phrCode"));
			System.out.println(message.getText());
		}
		if(message.getStringProperty("phrCode1")!=null){
			System.out.println(message.getStringProperty("phrCode1"));
			System.out.println(message.getText());
		}
	}
}
