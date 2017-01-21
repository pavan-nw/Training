package com.bt.rest.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.bt.jaxb.model.Invoice;

public class BillingClient {

	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();

		Client client = ClientBuilder.newClient(config);

		WebTarget target = client.target(getBaseURI());

		Builder builder = target.path("billing").path("invoice").path("1")
				.request();
		// String xmlAnswer = builder.accept(MediaType.APPLICATION_XML).get(
		// String.class);
		// System.out.println(xmlAnswer);

		Invoice invoice = builder.accept(MediaType.APPLICATION_XML).get(
				Invoice.class);
		System.out.println(invoice.getAmount());
		
		invoice.setAmount(5999.5);
		invoice.setId(null);
		
		builder = target.path("customers").request();
		invoice = builder.accept(MediaType.APPLICATION_XML).post(
				Entity.entity(invoice, MediaType.APPLICATION_XML), Invoice.class);
		 System.out.println(invoice.getId());

	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/rest-billing/api")
				.build();
	}

}
