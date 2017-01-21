package com.bt.service;

import javax.jws.HandlerChain;
import javax.jws.WebService;

import com.bt.domain.TariffPlan;

@WebService(endpointInterface="com.bt.service.TariffService")
@HandlerChain(file = "TariffService_handler.xml")
public class TariffServiceImpl implements TariffService {

	@Override
	public TariffPlan getTariffPlan(String planName) {
		//hard coding TariffPlan for the sake of demo
		return new TariffPlan("MonsoonDhamaka", 1000, 0.25F, 125, 199.0F);
	}

	@Override
	public TariffPlan getTariffPlanEconomy(String planName,
			Float upperPriceLimit) {
		return new TariffPlan("MonsoonEconomy", 1000, 0.25F, 125, 99.0F);
	}

	@Override
	public TariffPlan getTariffPlanLike(String planName, TariffPlan like) {
		return like;
	}

}
