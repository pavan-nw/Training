package com.bt.client;

import java.util.concurrent.ExecutionException;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import com.bt.service.GetTariffPlanResponse;
import com.bt.service.TariffPlan;

public class TariffPlanAsyncHandler implements
		AsyncHandler<GetTariffPlanResponse> {

	@Override
	public void handleResponse(Response<GetTariffPlanResponse> res) {
		GetTariffPlanResponse response;
		try {
			response = res.get();
			TariffPlan plan = response.getReturn();
			System.out.println("async using callback" + plan.getPlanName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
