package com.bt.ws.order;

import javax.xml.ws.Endpoint;

public class OrderServicePublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8888/orders", 
				new OrderServiceImpl());
	}

}
