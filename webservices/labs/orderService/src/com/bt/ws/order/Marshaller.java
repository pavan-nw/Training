package com.bt.ws.order;

import java.io.StringWriter;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeFactory;

public class Marshaller {
	public static void main(String[] args) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
		javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();

		Order order = new Order();
		order.setCreateTime(new Date());
		order.setItemName("itemName");
		order.setOrderDetails("order1 details");
		order.setOrderId("order1");
		order.setPrice(1000.50);
		order.setShipmentAddress("Ecospace");

		marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,
				true);
		StringWriter writer = new StringWriter();
		marshaller.marshal(order, writer);

		System.out.println(writer.toString());
	}
}
