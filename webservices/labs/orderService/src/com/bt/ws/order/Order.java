package com.bt.ws.order;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
	private String orderId;
	private String orderDetails;
	private String itemName;
	private String shipmentAddress;
	private double price;
	private Date createTime;
	private Customer customer;
	
	public Order() {
		super();
	}

	public Order(String orderId, String orderDetails, String itemName, String shipmentAddress, double price, Date createTime) {
		super();
		this.orderId = orderId;
		this.orderDetails = orderDetails;
		this.itemName = itemName;
		this.shipmentAddress = shipmentAddress;
		this.price = price;
		this.createTime = createTime;
	}
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getShipmentAddress() {
		return shipmentAddress;
	}

	public void setShipmentAddress(String shipmentAddress) {
		this.shipmentAddress = shipmentAddress;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDetails=" + orderDetails + ", itemName=" + itemName + ", shipmentAddress="
				+ shipmentAddress + ", price=" + price + ", createTime=" + createTime + "]";
	}

}
