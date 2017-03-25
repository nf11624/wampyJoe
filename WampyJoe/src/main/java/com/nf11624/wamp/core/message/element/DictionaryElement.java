package com.nf11624.wamp.core.message.element;

import com.nf11624.wamp.core.message.MessageDetails;
import com.nf11624.wamp.core.message.MessageElement;

public class DictionaryElement extends MessageElement<Object> {

	private MessageDetails details;

	public void setDetails(MessageDetails details) {
		this.details = details;

	}

	public MessageDetails getDetails() {
		return details;
	}

	@Override
	public Object getValue() {
		return getDetails();
	}
}
