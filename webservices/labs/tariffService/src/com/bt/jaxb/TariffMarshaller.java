package com.bt.jaxb;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.bt.domain.TariffPlan;

public class TariffMarshaller {

	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(TariffPlan.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			TariffPlan plan = new TariffPlan("MonsoonDhamaka", 1000, 
					0.25F, 125, 199.0F);
			StringWriter writer = new StringWriter();
			
			marshaller.marshal(plan, writer);
			
			System.out.println(writer.toString());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
