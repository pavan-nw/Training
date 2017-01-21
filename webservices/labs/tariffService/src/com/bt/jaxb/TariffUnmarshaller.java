package com.bt.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.bt.domain.TariffPlan;

public class TariffUnmarshaller {

	public static void main(String[] args) {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(TariffPlan.class);
			Unmarshaller um = context.createUnmarshaller();
			
			TariffPlan plan = (TariffPlan)um.unmarshal(new File("tariff.xml"));
			
			System.out.println(plan);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
