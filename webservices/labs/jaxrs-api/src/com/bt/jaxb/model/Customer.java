package com.bt.jaxb.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="account")
@XmlAccessorType(XmlAccessType.NONE)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class Customer {
	@XmlElement(required=true)
	private String accountNumber;
	@XmlElement
	private String name;
	@XmlElement(nillable=true)
	private String address;
	@XmlElement
	private Date regDate;
	
	public Customer() {
		super();
	}
	
	public Customer(String accountNumber, String name, String address,
			Date regDate) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.address = address;
		this.regDate = regDate;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", name=" + name
				+ ", address=" + address + ", regDate=" + regDate + "]";
	}

}
