package com.bt.jaxb.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace="model.jaxb.bt.com", name="bill")
//@XmlType(namespace="model.jaxb.bt.com")
public class Invoice {
	private Long id;
	private Customer customer;
	private Date invoiceDate;
	private Date dueDate;
	private Double amount;

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Invoice(Customer customer, Date invoiceDate, Date dueDate,
			Double amount) {
		super();
		this.customer = customer;
		this.invoiceDate = invoiceDate;
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public Invoice() {
		super();
	}

	@XmlElement(name="acc")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Invoice [customer=" + customer + ", invoiceDate=" + invoiceDate
				+ ", dueDate=" + dueDate + ", amount=" + amount + "]";
	}
	
}
