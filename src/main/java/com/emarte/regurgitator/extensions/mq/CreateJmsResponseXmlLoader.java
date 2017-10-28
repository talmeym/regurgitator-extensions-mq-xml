/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions.mq;

import com.emarte.regurgitator.core.*;
import org.w3c.dom.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.XmlConfigUtil.*;
import static com.emarte.regurgitator.extensions.mq.ExtensionsMqConfigConstants.*;

public class CreateJmsResponseXmlLoader implements XmlLoader<CreateJmsResponse> {
    private CreateResponseXmlLoader createResponseXmlLoader = new CreateResponseXmlLoader();

    @Override
    public CreateJmsResponse load(Element element, Set<Object> allIds) throws RegurgitatorException {
        CreateResponse response = (CreateResponse) createResponseXmlLoader.load(element, allIds);
        String messageId = loadOptionalStr(element, JMS_MESSAGE_ID);
        String type = loadOptionalStr(element, JMS_TYPE);
        String destination = loadOptionalStr(element, JMS_DESTINATION);
        String correlationId = loadOptionalStr(element, JMS_CORRELATION_ID);
        Integer deliveryMode = loadOptionalInt(element, JMS_DELIVERY_MODE);
        Long expiration = loadOptionalLong(element, JMS_EXPIRATION);
        Integer priority = loadOptionalInt(element, JMS_PRIORITY);
        Boolean redelivered = loadOptionalBool(element, JMS_REDELIVERED);
        String replyTo = loadOptionalStr(element, JMS_REPLY_TO);
        Long timestamp = loadOptionalLong(element, JMS_TIMESTAMP);
        return new CreateJmsResponse(response, messageId, type, destination, correlationId, deliveryMode, expiration, priority, redelivered, replyTo, timestamp);
    }
}
