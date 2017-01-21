package com.bt.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import com.bt.service.GetTariffPlanResponse;
import com.bt.service.TariffPlan;
import com.bt.service.TariffService;
import com.bt.service.TariffServiceImplService;

public class TariffAsyncClient {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException, TimeoutException {
		TariffService svc = new TariffServiceImplService()
				.getTariffServiceImplPort();

		TariffPlan plan = svc.getTariffPlan("myplan"); // sync
		System.out.println("sync :" + plan.getPlanName());

		Response<GetTariffPlanResponse> response = svc
				.getTariffPlanAsync("myplan"); // async with timeout
		// polling response
		plan = null;
		do {
			try {
				GetTariffPlanResponse result = response.get(100,
						TimeUnit.MILLISECONDS);
				plan = result.getReturn();
			} catch (TimeoutException e) {
				// continue polling
			}
		} while (plan == null);
		System.out.println("async polling:" + plan.getPlanName());
		
		//async using callback
		AsyncHandler<GetTariffPlanResponse> asyncHandler = new TariffPlanAsyncHandler();
		svc.getTariffPlanAsync("my", asyncHandler);
		
		Thread.sleep(1000);
	}

}
