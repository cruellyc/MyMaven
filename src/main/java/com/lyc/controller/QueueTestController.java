package com.lyc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lyc.service.ConsumerService;
import com.lyc.service.ProducerService;

/**
 *
 * @author liyc
 * @date 2017年6月21日 下午2:46:58
 */
@Controller
public class QueueTestController {
	// 队列名gzframe.demo
	@Resource(name = "lycQueueDestination")
	private Destination lycQueueDestination;

	// 队列消息生产者
	@Resource(name = "producerService")
	private ProducerService producer;

	// 队列消息消费者
	@Resource(name = "consumerService")
	private ConsumerService consumer;

	@RequestMapping(value = "/producer", method = RequestMethod.GET)
	public ModelAndView producer() {
		System.out.println("------------go producer");

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(now);
		System.out.println(time);

		ModelAndView mv = new ModelAndView();
		mv.addObject("time", time);
		mv.setViewName("jms_producer");
		return mv;
	}

	@RequestMapping(value = "/onsend", method = RequestMethod.POST)
	public ModelAndView producer(@RequestParam("message") String message) {
		System.out.println("------------send to jms");
		ModelAndView mv = new ModelAndView();
		producer.sendMessage(lycQueueDestination, message);
		mv.setViewName("welcome");
		return mv;
	}

	@RequestMapping(value = "/receive", method = RequestMethod.GET)
	public ModelAndView queue_receive() throws JMSException {
		System.out.println("------------receive message");
		ModelAndView mv = new ModelAndView();

		TextMessage tm = consumer.receive(lycQueueDestination);
		mv.addObject("textMessage", tm.getText());

		mv.setViewName("queue_receive");
		return mv;
	}

}
