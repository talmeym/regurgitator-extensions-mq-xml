/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions.mq;

import org.w3c.dom.Element;
import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.core.XmlLoader;

import java.util.Set;

import static uk.emarte.regurgitator.core.XmlConfigUtil.loadId;
import static uk.emarte.regurgitator.core.XmlConfigUtil.loadMandatoryStr;
import static uk.emarte.regurgitator.extensions.mq.ExtensionsMqConfigConstants.DESTINATION;

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