package com.bt.rest.crud.provider;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

public class JacksonFeature implements Feature {
	public boolean configure(FeatureContext context) {
		String disableMoxy = "jersey.config.disableMoxyJson."
				+ context.getConfiguration().getRuntimeType().name()
						.toLowerCase();
		context.property(disableMoxy, (Object) true);
		context.register((Class) JacksonJaxbJsonProvider.class, new Class[] {
				MessageBodyReader.class, MessageBodyWriter.class });
		return true;
	}
}