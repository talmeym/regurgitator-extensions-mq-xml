package com.emarte.regurgitator.extensions.mq;

import com.emarte.regurgitator.core.*;
import org.w3c.dom.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.XmlConfigUtil.getAttribute;
import static com.emarte.regurgitator.extensions.mq.ExtensionsMqConfigConstants.*;

public class CreateJmsResponseXmlLoader implements XmlLoader<CreateJmsResponse> {
	private CreateResponseXmlLoader createResponseXmlLoader = new CreateResponseXmlLoader();

	@Override
	public CreateJmsResponse load(Element element, Set<Object> allIds) throws RegurgitatorException {
		CreateResponse response = (CreateResponse) createResponseXmlLoader.load(element, allIds);
		String messageId = getAttribute(element, JMS_MESSAGE_ID);
		String type = getAttribute(element, JMS_TYPE);
		String destination = getAttribute(element, JMS_DESTINATION);
		String correlationId = getAttribute(element, JMS_CORRELATION_ID);
		String deliveryMode = getAttribute(element, JMS_DELIVERY_MODE);
		String expiration = getAttribute(element, JMS_EXPIRATION);
		String priority = getAttribute(element, JMS_PRIORITY);
		String redelivered = getAttribute(element, JMS_REDELiVERED);
		String replyTo = getAttribute(element, JMS_REPLY_TO);
		String timestamp = getAttribute(element, JMS_TIMESTAMP);
		return new CreateJmsResponse(response, messageId, type, destination, correlationId, deliveryMode, expiration, priority, redelivered, replyTo, timestamp);
	}
}
