package com.ramselabs.client;

import java.net.MalformedURLException;
import java.net.URL;

import com.ramselabs.ws.ServerInfo;
import com.ramselabs.ws.ServerInfoService;

public class WsClient {
	public static void main(String[] args) throws MalformedURLException {
		ServerInfoService sis = new ServerInfoService(new URL("http://localhost:8888/ws/server?wsdl"));
		ServerInfo si = sis.getServerInfoPort();
 
		System.out.println(si.getServerName());
	}

}
