package com.bt.ws.order;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface = "com.bt.ws.order.OrderService")
public class OrderServiceImpl implements OrderService {
	private static List<Order> orders = new ArrayList<Order>();

	@Override
	public void createOrder(Order order, String client) {
		System.out.println(order);
		System.out.println("client " + client);
		orders.add(order);
	}

	@Override
	public Order getOrder(String orderId) {
		for (Order order : orders) {
			if (orderId.equals(order.getOrderId())) {
				return order;
			}
		}
		return null;
	}

}
