package com.nf11624.wamp.core.message.session.builder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import com.nf11624.wamp.core.message.Message;
import com.nf11624.wamp.core.message.MessageBuilder;
import com.nf11624.wamp.core.message.MessageElement;
import com.nf11624.wamp.core.message.element.DictionaryElement;
import com.nf11624.wamp.core.message.element.URIElement;
import com.nf11624.wamp.core.message.json.JSONToken;
import com.nf11624.wamp.core.message.session.HelloMessage;
import com.nf11624.wamp.core.message.session.HelloMessage.Field;
import com.nf11624.wamp.core.message.session.definition.HelloMessageDetails;

public class HelloMessageBuilder extends MessageBuilder<HelloMessage> {

	public Message buildFromPayload(String payload) {
		HelloMessage message = new HelloMessage();
		JSONToken[] messageTokens = message.generateTokens(payload.toString());
		MessageElement<String> name = new MessageElement<String>() {

		};
		name.setValue(messageTokens[Field.Name.ordinal()].getValue());
		MessageElement<URI> realm = new URIElement();
		realm.setValue(URI.create(trimQuotes(messageTokens[Field.Realm.ordinal()].getValue())));
		DictionaryElement details = dictionaryElementBuilder
				.buildDictionaryElement(messageTokens[Field.Details.ordinal()].getValue(), HelloMessageDetails.class);
		Map<String, MessageElement<?>> messageElements = new HashMap<String, MessageElement<?>>();
		messageElements.put("NAME", name);
		messageElements.put("REALM", realm);
		messageElements.put("DETAILS", details);
		message.setMessageElements(messageElements);
		return message;
	}

	@Override
	public Class<? extends Message> getMessageType() {
		return HelloMessage.class;
	}

	public String trimQuotes(String str) {
		if (str.charAt(0) == '"') {
			str = str.substring(1);
		}
		if (str.charAt(str.length() - 1) == '"') {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}
}