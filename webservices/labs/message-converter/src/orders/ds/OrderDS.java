package orders.ds;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import orders.entity.Order;

public class OrderDS {
	@Autowired
	private CustomerDS customerDS;

	private List<Order> orders = new ArrayList<Order>();

	public OrderDS() {
	}
	
	public void setCustomerDS(CustomerDS customerDS) {
		this.customerDS = customerDS;
	}

	public void init() {
		orders.add(new Order(1, "Order 1", 1000.0, customerDS.get(1)));
		orders.add(new Order(2, "Order 2", 2000.0, customerDS.get(1)));
		orders.add(new Order(3, "Order 3", 3000.0, customerDS.get(2)));
		orders.add(new Order(4, "Order 4", 4000.0, customerDS.get(2)));
		orders.add(new Order(5, "Order 5", 5000.0, 
				customerDS.get(3)));
		orders.add(new Order(6, "Order 6", 6000.0, 
				customerDS.get(4)));
	}

	public Order get(Integer id) {
		return orders.get(id - 1);
	}

	public CustomerDS getCustomerDS() {
		return customerDS;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void add(Order order) {
		order.setId(orders.size() + 1);
		orders.add(order);
	}

	public void delete(Integer id) {
		Order o = this.get(id);
		orders.remove(o);
	}

}
