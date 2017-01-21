package com.ramselabs.publisher;

import javax.xml.ws.Endpoint;

import com.ramselabs.ws.ServerInfo;

public class WsPublisher {

	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:8888/ws/server", new ServerInfo());
		System.out.println("Service is published!");

	}

}
