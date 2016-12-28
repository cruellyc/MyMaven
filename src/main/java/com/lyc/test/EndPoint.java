package com.lyc.test;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 *
 * @author  liyc
 * @date 2016年12月28日 上午11:04:39
*/
public abstract class EndPoint {
	protected Channel channel;
	protected Connection connection;
	protected String endpointName;
	
	public EndPoint(String endpointName) throws IOException{
		this.endpointName=endpointName;
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("10.16.8.22");
		connection=factory.newConnection();
		channel=connection.createChannel();
		channel.queueDeclare(endpointName, false, false, false, null);
	}
	
	public void close() throws IOException{
		this.channel.close();
		this.connection.close();
	}
}
