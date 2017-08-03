package com.lyc.test;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 *
 * @author liyc
 * @date 2017年8月3日 上午11:31:39
 */
public class SimpleJMSSender {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("./conf/activeMqTopicSend.xml");

		JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("myJmsTemplate");
		for (int i = 0; i < 10; i++) {
			System.out.println("seed"+i);
			jmsTemplate.send(new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					TextMessage msg = session.createTextMessage();
					// 设置消息属性
					msg.setStringProperty("phrCode", "C001");
					// 设置消息内容
					msg.setText("Hello World!");
					return msg;
				}
			});
			jmsTemplate.send(new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					TextMessage msg = session.createTextMessage();
					// 设置消息属性
					msg.setStringProperty("phrCode1", "C002");
					// 设置消息内容
					msg.setText("Hello World !!!!");
					return msg;
				}
			});
		}
	}
}
