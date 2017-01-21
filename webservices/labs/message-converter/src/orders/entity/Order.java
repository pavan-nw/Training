package orders.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
	private Integer id;
	private String description;
	private Double amount;
	private Customer customer;
	
	public Order() {
		super();
	}
	public Order(Integer id, String description, Double amount,
			Customer customer) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.customer = customer;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
