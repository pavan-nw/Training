package com.ramselabs.handler;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.ramselabs.encrypt.HashEncryptUtil;

public class EncryptHashInjectHandler implements
		SOAPHandler<SOAPMessageContext> {

	public boolean handleMessage(SOAPMessageContext context) {

		System.out.println("Client : handleMessage()......");

		Boolean isRequest = (Boolean) context
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		// if this is a request, true for outbound messages, false for inbound
		if (isRequest) {

			try {
				SOAPMessage soapMsg = context.getMessage();
				SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
				SOAPHeader soapHeader = soapEnv.getHeader();

				// if no header, add one
				if (soapHeader == null) {
					soapHeader = soapEnv.addHeader();
				}

				// get encryptedData
				String encryptedData = getEncryptedHashData();

				// add a soap header, name as "encryptedData"
				QName qname = new QName("http://ws.ramselabs.com/",
						"encryptedData");
				SOAPHeaderElement soapHeaderElement = soapHeader
						.addHeaderElement(qname);

				soapHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
				soapHeaderElement.addTextNode(encryptedData);
				soapMsg.saveChanges();

				// tracking
				soapMsg.writeTo(System.out);

			} catch (SOAPException e) {
				System.err.println(e);
			} catch (IOException e) {
				System.err.println(e);
			}

		}

		// continue other handler chain
		return true;
	}

	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("Client : handleFault()......");
		return true;
	}

	public void close(MessageContext context) {
		System.out.println("Client : close()......");
	}

	public Set<QName> getHeaders() {
		System.out.println("Client : getHeaders()......");
		return null;
	}

	// return encrypted data
	private String getEncryptedHashData() {
		String encryptedData = null;
		try {
			encryptedData = HashEncryptUtil.hashPassword("ramlabs123");
			System.out.println("Encrypted Data :" + encryptedData);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encryptedData;
	}

}
