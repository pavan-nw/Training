package com.ramselabs.handler;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import com.ramselabs.encrypt.HashEncryptUtil;

public class EncryptHashValidatorHandler implements
		SOAPHandler<SOAPMessageContext> {

	@SuppressWarnings("rawtypes")
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("Server : handleMessage()......");

		Boolean isResponse = (Boolean) context
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		// for response message only, true for outbound messages, false for
		// inbound
		if (!isResponse) {

			try {
				SOAPMessage soapMsg = context.getMessage();
				SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
				SOAPHeader soapHeader = soapEnv.getHeader();

				// if no header, add one
				if (soapHeader == null) {
					soapHeader = soapEnv.addHeader();
					// throw exception
					generateSOAPErrMessage(soapMsg, "No SOAP header.");
				}

				// Get client mac address from SOAP header
				Iterator it = soapHeader
						.extractHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);

				// if no header block for next actor found? throw exception
				if (it == null || !it.hasNext()) {
					generateSOAPErrMessage(soapMsg,
							"No header block for next actor.");
				}

				// if no encrytedData found? throw exception
				Node encryptedDataNode = (Node) it.next();
				String encrytedDataValue = (encryptedDataNode == null) ? null : encryptedDataNode.getValue();

				if (encrytedDataValue == null) {
					generateSOAPErrMessage(soapMsg,
							"No mac address in header block.");
				}

				// if encrytedData is not match, throw exception
				try {
					if (!encrytedDataValue.equals(HashEncryptUtil.hashPassword("ramlabs123")))
							{
						generateSOAPErrMessage(soapMsg,
								"Invalid encrytedData address, access is denied.");
					}
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}

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
		System.out.println("Server : handleFault()......");

		return true;
	}

	public void close(MessageContext context) {
		System.out.println("Server : close()......");

	}

	public Set<QName> getHeaders() {
		System.out.println("Server : getHeaders()......");
		return null;
	}

	private void generateSOAPErrMessage(SOAPMessage msg, String reason) {
		try {
			SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
			SOAPFault soapFault = soapBody.addFault();
			soapFault.setFaultString(reason);
			throw new SOAPFaultException(soapFault);
		} catch (SOAPException e) {
		}
	}

}
