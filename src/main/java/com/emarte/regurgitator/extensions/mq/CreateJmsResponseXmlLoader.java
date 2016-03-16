package com.emarte.regurgitator.extensions.mq;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.Set;

import static com.emarte.regurgitator.extensions.mq.ExtensionsMqConfigConstants.*;

public class CreateJmsResponseXmlLoader implements XmlLoader<CreateJmsResponse> {
	CreateResponseXmlLoader createResponseXmlLoader = new CreateResponseXmlLoader();

	@Override
	public CreateJmsResponse load(Element element, Set<Object> allIds) throws RegurgitatorException {
		CreateResponse response = (CreateResponse) createResponseXmlLoader.load(element, allIds);
		String destination = element.attributeValue(JMS_DESTINATION);
		String correlationId = element.attributeValue(JMS_CORRELATION_ID);
		String type = element.attributeValue(JMS_TYPE);
		return new CreateJmsResponse(response, destination, correlationId, type);
	}
}
