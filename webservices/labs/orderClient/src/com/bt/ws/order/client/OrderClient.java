package com.bt.ws.order.client;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import com.bt.ws.order.Order;
import com.bt.ws.order.OrderService;
import com.bt.ws.order.OrderServiceProxy;

public class OrderClient {

	public static void main(String[] args) throws RemoteException {
		OrderService svc = new OrderServiceProxy("http://localhost:9999/orders?wsdl").getOrderService();

		Order order = new Order(new GregorianCalendar(), "itemName", "order1 details", "order1", 1000.50, "Ecospace");
		svc.addOrder(order, "standalone");

		Order myorder = svc.getOrder("order1");
		System.out.println(myorder.getOrderDetails());
	}

}
