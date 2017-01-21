package com.bt.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.bt.domain.TariffPlan;

@WebService
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED)
public interface TariffService {
	@WebMethod
	TariffPlan getTariffPlan(String planName);

	@WebMethod
	TariffPlan getTariffPlanEconomy(String planName, Float upperPriceLimit);

	@WebMethod
	TariffPlan getTariffPlanLike(String planName, TariffPlan like);

}
