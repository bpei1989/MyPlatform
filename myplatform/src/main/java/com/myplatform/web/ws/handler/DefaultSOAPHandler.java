package com.myplatform.web.ws.handler;

import java.io.ByteArrayOutputStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.log4j.Logger;



public class DefaultSOAPHandler implements SOAPHandler<SOAPMessageContext> 
{

	private static final Logger logger = Logger.getLogger(DefaultSOAPHandler.class);

	@Override
	public boolean handleMessage(SOAPMessageContext soapMessageContext) 
	{
		logger.info("=========  Handle SOAP Message ========= ");
		
		Boolean outboundProperty = (Boolean) soapMessageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		SOAPMessage message = soapMessageContext.getMessage();
		
		if (outboundProperty) 
		{
			logger.info("soap in");
		} 
		else 
		{
			logger.info("soap out");

			QName qname = new QName("http://ws.cxf.testcase.com/", "TestCase");
			try 
			{
				SOAPHeaderElement soapHeaderElement = message.getSOAPHeader().addHeaderElement(qname);
				soapHeaderElement.addTextNode("justForTesting");
				message.saveChanges();
			} 
			catch (SOAPException ex) 
			{
				logger.error("异常：", ex);
			}
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try 
		{
			message.writeTo(out);
			logger.info("SOAP\n" + new String(out.toByteArray(), "UTF-8"));
		} 
		catch (Exception ex) 
		{
			logger.error("handle SOAP exception", ex);
		}

		logger.info("======= HandleMessage Finished========= ");

		return true;

	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	@Override
	public void close(MessageContext context) {
		// nothing here

	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}

