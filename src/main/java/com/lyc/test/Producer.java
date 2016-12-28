package com.lyc.test;

import java.io.IOException;
import java.io.Serializable;

import org.springframework.util.SerializationUtils;

/**
 * 生产者
 * @author  liyc
 * @date 2016年12月28日 上午11:11:38
*/
public class Producer extends EndPoint {

	public Producer(String endpointName) throws IOException {
		super(endpointName);
		// TODO Auto-generated constructor stub
	}
	public void sendMessage(Serializable object) throws IOException{
		channel.basicPublish("", endpointName, null, SerializationUtils.serialize(object));
	}
}
