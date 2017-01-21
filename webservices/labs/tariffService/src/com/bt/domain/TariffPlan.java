package com.bt.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tariff")
@XmlAccessorType(XmlAccessType.FIELD)
public class TariffPlan {
	private String planName;
	private Integer freeCalls;
	private Float callRatePerMin;
	
	private transient Integer dataSpeed;
	private Float price;

	public TariffPlan(String planName, Integer freeCalls, Float callRatePerMin,
			Integer dataSpeed, Float price) {
		super();
		this.planName = planName;
		this.freeCalls = freeCalls;
		this.callRatePerMin = callRatePerMin;
		this.dataSpeed = dataSpeed;
		this.price = price;
	}

	public TariffPlan() {
		super();
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Integer getFreeCalls() {
		return freeCalls;
	}

	public void setFreeCalls(Integer freeCalls) {
		this.freeCalls = freeCalls;
	}

	public Float getCallRatePerMin() {
		return callRatePerMin;
	}

	public void setCallRatePerMin(Float callRatePerMin) {
		this.callRatePerMin = callRatePerMin;
	}

	public Integer getDataSpeed() {
		return dataSpeed;
	}

	public void setDataSpeed(Integer dataSpeed) {
		this.dataSpeed = dataSpeed;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TariffPlan [planName=" + planName + ", freeCalls=" + freeCalls
				+ ", callRatePerMin=" + callRatePerMin + ", dataSpeed="
				+ dataSpeed + ", price=" + price + "]";
	}

}
