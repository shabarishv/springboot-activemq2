package com.volvo.jms.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volvo.jms.client.JmsClient;
import com.volvo.jms.consumer.JmsConsumer;
import com.volvo.jms.producer.JmsProducer;

@Service
public class JmsClientImpl implements JmsClient{

	@Autowired
	JmsConsumer jmsConsumer;
	
	@Autowired
	JmsProducer jmsProducer;
	
	@Override
	public void send(String msg) {
		jmsProducer.send(msg);
	}

	@Override
	public String receive() {
		return jmsConsumer.receive();
	}

}
