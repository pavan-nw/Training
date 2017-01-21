package orders.controller;

import static org.junit.Assert.*;

import orders.entity.Order;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class OrderControllerTest {
	private static RestTemplate restTemplate;
	private static RestTemplate restTemplateWithConverters;

	private static HttpEntity<String> prepareGet(MediaType type) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(type);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return entity;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"WebContent/WEB-INF/converter-servlet.xml",
				"WebContent/WEB-INF/converter-context.xml");
		restTemplateWithConverters = (RestTemplate) ctx.getBean("restTemplate");

		restTemplate = new RestTemplate();
	}

	@Test
	public void testGetOrderObject() {
		Order order = restTemplateWithConverters.getForObject(
				"http://localhost:8080/message-converter/service/orders/{id}",
				Order.class, "1");
		System.out.println(order.getDescription());
	}

	@Test
	public void testGetOrderString() {
		try {
			String response = restTemplate
					.getForObject(
							"http://localhost:8080/message-converter/service/orders/{id}",
							String.class, "1");
			System.out.println(response);
		} catch (Exception e) {
			fail("Unexpected error " + e.getMessage());
		}
	}

	@Test
	public void testAddOrder() {
		try {
			Order newOrder = new Order(-1, "Order 99", 99.0, null);
			newOrder = restTemplateWithConverters.postForObject(
					"http://localhost:8080/message-converter/service/orders",
					newOrder, Order.class);
			assertTrue(newOrder.getId() != -1);
			System.out.println(newOrder.getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testDeleteOrder() {
		try {
			restTemplateWithConverters
					.delete("http://localhost:8080/message-converter/service/orders/{id}",
							"2");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
