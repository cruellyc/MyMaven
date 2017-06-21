package com.lyc.service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * 接收消息
 * @author liyc
 * @date 2017年6月21日 下午2:42:40
 */
@Service
public class ConsumerService {

	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;

	/**
	 * 接收消息
	 */
	public TextMessage receive(Destination destination) {
		TextMessage tm = (TextMessage) jmsTemplate.receive(destination);
		try {
			System.out.println("从队列" + destination.toString() + "收到了消息：\t" + tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}

		return tm;

	}

}
