package com.nf11624.wamp.core.message.element;

import java.net.URI;

import com.nf11624.wamp.core.message.ElementType;
import com.nf11624.wamp.core.message.MessageElement;

public class URIElement extends MessageElement<URI> {

	public URIElement() {
		type = ElementType.URI;
	}

}
