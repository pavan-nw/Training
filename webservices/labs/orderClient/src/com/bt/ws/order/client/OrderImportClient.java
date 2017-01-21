package com.bt.ws.order.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.ws.BindingProvider;

import com.bt.ws.orderimport.Order;
import com.bt.ws.orderimport.OrderService;
import com.bt.ws.orderimport.OrderServiceImplService;

public class OrderImportClient {

	public static void main(String[] args)
			throws DatatypeConfigurationException, MalformedURLException {
		OrderService svc = new OrderServiceImplService().getOrderServiceImplPort();
		((BindingProvider) svc).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"http://localhost:9999/orders");
		
		Order order = new Order();
		order.setCreateTime(DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(new GregorianCalendar()));
		order.setItemName("itemName");
		order.setOrderDetails("order1 details");
		order.setOrderId("order1");
		order.setPrice(1000.50);
		order.setShipmentAddress("Ecospace");

		svc.addOrder(order, "standalone");

		Order myorder = svc.getOrder("order1");
		System.out.println(myorder.getOrderDetails());

	}

}
