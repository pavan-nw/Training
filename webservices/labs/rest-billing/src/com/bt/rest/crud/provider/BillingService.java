package com.bt.rest.crud.provider;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;

import com.bt.jaxb.model.Customer;
import com.bt.jaxb.model.Invoice;

@Path("/billing")
public class BillingService {
	private static Long invoiceCount = 0L;
	private static Map<Long, Invoice> invoices = new HashMap<Long, Invoice>();

	@Path("/customer/{custId}/invoice")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Invoice getInvoice(@PathParam("custId") String customerId,
			@QueryParam("invoiceCycle") String invoiceCycle)
			throws InvalidCustomerException {
		if (customerId == null) {
			throw new RuntimeException("Invalid customer");
		}
		if (customerId.equals("12345")) {
			throw new InvalidCustomerException(customerId + " doesnt exist");
		}
		// Customer customer = new Customer("000123456", "Arun",
		// null, new Date());

		Invoice invoice = new Invoice(new Customer(customerId, invoiceCycle,
				"Blr", new Date()), new Date(), new Date(), 1999.0);

		return invoice;

	}

	@Path("/customer/{custId}/invoice")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
	public Invoice getInvoiceAsXml(@PathParam("custId") String customerId,
			@QueryParam("invoiceCycle") String invoiceCycle)
			throws InvalidCustomerException {
		if (customerId == null) {
			throw new RuntimeException("Invalid customer");
		}
		if (customerId.equals("12345")) {
			throw new InvalidCustomerException(customerId + " doesnt exist");
		}
		// Customer customer = new Customer("000123456", "Arun",
		// null, new Date());

		Invoice invoice = new Invoice(new Customer(customerId, invoiceCycle,
				"Blr", new Date()), new Date(), new Date(), 1999.0);

		return invoice;

	}

	@Path("/invoice")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Invoice createInvoice(Invoice invoice) {
		invoice.setId(++invoiceCount);

		invoices.put(invoiceCount, invoice);
		return invoice;
	}

	@Path("/invoice/{invoiceId}")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Invoice createInvoice(@PathParam("invoiceId") Long id,
			Invoice invoice) {
		invoices.put(id, invoice);

		return invoice;
	}

	@GET
	@Path("/invoice/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Invoice get(@PathParam("id") Long invoiceId) {
		return invoices.get(invoiceId);
	}

	@DELETE
	@Path("/invoice/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Invoice delete(@PathParam("id") Long invoiceId) {
		return invoices.remove(invoiceId);
	}

	@GET
	@Path("/invoice/{id}")
//	@Produces({ MediaType.TEXT_HTML })
	public Viewable getInvoiceHtml(@Context HttpServletRequest request,
			@Context HttpServletResponse response,
			@PathParam("id") Long invoiceId) {
		Invoice invoice = invoices.get(invoiceId);
		request.setAttribute("invoice", invoice);
		
		return new Viewable("invoice.jsp");
	}

}
