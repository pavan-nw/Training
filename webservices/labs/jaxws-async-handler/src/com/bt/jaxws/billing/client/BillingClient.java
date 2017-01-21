package com.bt.jaxws.billing.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Response;

import com.bt.jaxws.billing.BillingService;
import com.bt.jaxws.billing.BillingServiceService;
import com.bt.jaxws.billing.Customer;
import com.bt.jaxws.billing.InvalidCustomerException_Exception;
import com.bt.jaxws.billing.Invoice;

public class BillingClient {

	public static void main(String[] args) {
		BillingService service = new BillingServiceService()
				.getBillingServicePort();
		((BindingProvider) service).getRequestContext().put(
				BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://localhost:8080/jaxws-web/api/billing");

		Invoice invoice;
		try {
			// synchronous call
			invoice = service.getInvoice(new Customer(), "0815");
			System.out.println(invoice.getAmount());

			// async with handler
			Future<Invoice> future = (Future<Invoice>) service.getInvoiceAsync(
					new Customer(), "99999", new BillingAsyncHandler());

			// async with polling
			Response<Invoice> response = service.getInvoiceAsync(
					new Customer(), "1345");
			invoice = null;
			do {
				try {
					invoice = response.get(10, TimeUnit.MILLISECONDS);
				} catch (InterruptedException | ExecutionException
						| TimeoutException e) {
					e.printStackTrace();
				}
			} while (invoice == null);
			System.out.println("From polling " + invoice.getAmount());
		} catch (InvalidCustomerException_Exception e) {
			e.printStackTrace();
		}
	}

	static class BillingAsyncHandler implements AsyncHandler<Invoice> {

		@Override
		public void handleResponse(Response<Invoice> res) {
			try {
				System.err.println("From Handler " + res.get().getAmount());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}

		}
	}
}
