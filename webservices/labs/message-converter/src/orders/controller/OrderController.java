package orders.controller;

import java.util.ArrayList;
import java.util.List;

import orders.ds.OrderDS;
import orders.entity.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
	@Autowired
	private OrderDS orderDS;

	public void setOrderDS(OrderDS orderDS) {
		this.orderDS = orderDS;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/orders")
	public @ResponseBody
	List<Order> getOrder() {
		return orderDS.getOrders();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/orders/{id}")
	public @ResponseBody
	Order getOrder(@PathVariable("id") Integer id) {
		Order order = orderDS.get(id);
		return order;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/orders", headers = "Accept=application/json")
	public @ResponseBody
	Order addOrder(@RequestBody Order order) {
		orderDS.add(order);

		return order;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/orders")
	public ModelAndView addOrderHtml(@ModelAttribute Order order) {
		orderDS.add(order);

		return new ModelAndView("order", "myOrder", order);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/orders", headers = "Accept=text/html")
	public ModelAndView getOrdersHtml() {
		return new ModelAndView("orders", "ordersList", orderDS.getOrders());
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/orders/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable("id") Integer id) {
		orderDS.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/orders/{id}", headers = "Accept=text/html")
	public ModelAndView getOrders(@PathVariable("id") Integer id) {
		Order order = orderDS.get(id);
		System.out.println("Order " + order);
		return new ModelAndView("order", "myOrder", order);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/orders/customer/{id}")
	public ModelAndView getOrdersByCustomer(
			@PathVariable("id") Integer customerId) {
		List<Order> orders = orderDS.getOrders();
		List<Order> filteredOrders = new ArrayList<Order>();
		for (Order o : orders) {
			if (customerId.equals(o.getCustomer().getId())) {
				filteredOrders.add(o);
			}
		}
		return new ModelAndView("orders", "ordersList", filteredOrders);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/orders", params = "customerName")
	public ModelAndView getOrdersByCustomerName(
			@RequestParam("customerName") String cusName) {
		List<Order> orders = orderDS.getOrders();
		List<Order> filteredOrders = new ArrayList<Order>();
		for (Order o : orders) {
			if (cusName.equals(o.getCustomer().getName())) {
				filteredOrders.add(o);
			}
		}
		return new ModelAndView("orders", "ordersList", filteredOrders);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/orders")
	public ModelAndView createOrder(@ModelAttribute Order order) {
		orderDS.add(order);
		return new ModelAndView("order", "myOrder", order);
	}

}