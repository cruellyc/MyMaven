package com.lyc.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.SerializationUtils;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

/**
 * 消费者
 * @author  liyc
 * @date 2016年12月28日 上午11:15:28
*/
public class QueueConsumer extends EndPoint implements Runnable, Consumer{

	public QueueConsumer(String endpointName) throws IOException {
		super(endpointName);
		// TODO Auto-generated constructor stub
	}

	public void handleCancel(String arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void handleCancelOk(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void handleConsumeOk(String consumerTag) {
		System.out.println("Consumer "+consumerTag +" registered");		
	}

	public void handleDelivery(String consumerTag, Envelope env,
			BasicProperties props, byte[] body) throws IOException {
		Map map = (HashMap)SerializationUtils.deserialize(body);
		System.out.println("Message Number "+ map.get("message number") + " received.");
		
	}

	public void handleRecoverOk(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void handleShutdownSignal(String arg0, ShutdownSignalException arg1) {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		try {
			channel.basicConsume(endpointName, true,this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
