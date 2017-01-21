package com.bt.client;

import com.bt.service.TariffService;
import com.bt.service.TariffServiceImplService;

public class TariffClient {

	public static void main(String[] args) {
		TariffServiceImplService svcFactory = new TariffServiceImplService();
		TariffService svcProxy = svcFactory.getTariffServiceImplPort();
		
		System.out.println(svcProxy.getTariffPlan("myplan").getPlanName());
		
	}

}
