package com.bt.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.bt.service.TariffService;

public class TariffClient {

	private static URL wsdlDocumentLocation = null;
	private static QName serviceName = new QName("http://service.bt.com/", 
			"TariffServiceImplService");

	static {
		try {
			wsdlDocumentLocation 
			= new URL("http://localhost:8888/tariffs?wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Service svc = 
				Service.create(wsdlDocumentLocation, serviceName);
		TariffService tariffSvc = svc.getPort(TariffService.class);
		
		System.out.println(tariffSvc.getClass().getInterfaces()[0]);
		System.out.println(tariffSvc.getTariffPlan("gen").
				getPlanName());
		
	}
}
