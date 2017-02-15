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
		String destination = getAttribute(element, JMS_DESTINATION);
		String correlationId = getAttribute(element, JMS_CORRELATION_ID);
		String type = getAttribute(element, JMS_TYPE);
		return new CreateJmsResponse(response, destination, correlationId, type);
	}
}
