package com.myplatform.web.ws.handler;

import java.io.ByteArrayOutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.log4j.Logger;


//LogicalHandler:只能获取到soap消息的body,请求会先经过LogicalHandler再经过SOAPHandler到服务器容器
public class DefaultLogicalHandler implements LogicalHandler<LogicalMessageContext> {

	private static final Logger logger = Logger.getLogger(DefaultLogicalHandler.class);

	@Override
	public boolean handleMessage(LogicalMessageContext logicalMessageContext) {
		logger.info("=========  handleMessage ========= ");

		Boolean outboundProperty = (Boolean) logicalMessageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (outboundProperty) {
			logger.info("handler in");
		} 
		else {
			logger.info("handler out");
		}

		LogicalMessage logicalMessage = logicalMessageContext.getMessage();
		Source payload = logicalMessage.getPayload();

		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Result result = new StreamResult(out);
			transformer.transform(payload, result);
			logger.info("SOAP\n" + new String(out.toByteArray(), "UTF-8"));
		} 
		catch (Exception ex) {
			logger.error("exception", ex);
		}

		return true;
	}

	@Override
	public boolean handleFault(LogicalMessageContext context) {
		return true;
	}

	@Override
	public void close(MessageContext context) {
		// nothing here
	}

}

