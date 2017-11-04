/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions.mq;

import com.emarte.regurgitator.core.*;
import org.w3c.dom.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.XmlConfigUtil.loadId;
import static com.emarte.regurgitator.core.XmlConfigUtil.loadMandatoryStr;
import static com.emarte.regurgitator.extensions.mq.ExtensionsMqConfigConstants.DESTINATION;

public class JmsCallXmlLoader implements XmlLoader<JmsCall> {
    private static final Log log = Log.getLog(JmsCallXmlLoader.class);

    @Override
    public JmsCall load(Element element, Set<Object> allIds) throws RegurgitatorException {
        MqMessagingSystem mqMessagingSystem = MqMessagingLookup.mqMessagingSystem();

        String id = loadId(element, allIds);
        log.debug("Loaded jms call '{}'", id);
        return new JmsCall(id, mqMessagingSystem, loadMandatoryStr(element, DESTINATION));
    }
}