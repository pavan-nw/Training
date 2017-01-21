package orders.ds;

import java.util.ArrayList;
import java.util.List;

import orders.entity.Customer;

public class CustomerDS {
	private List<Customer> customers = new ArrayList<Customer>();
	
	public CustomerDS() {
		customers.add(new Customer(1, "Customer 1"));
		customers.add(new Customer(2, "Customer 2"));
		customers.add(new Customer(3, "Customer 3"));
		customers.add(new Customer(4, "Customer 4"));
	}
	
	public Customer get(int i) {
		return customers.get(i - 1);
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}

}
