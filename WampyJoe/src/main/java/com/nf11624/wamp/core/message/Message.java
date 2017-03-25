package com.nf11624.wamp.core.message;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.nf11624.wamp.core.message.json.JSONToken;

/**
 * 
 * 6. Messages
 * 
 * All WAMP messages are a "list" with a first element "MessageType" followed by one or more message type specific elements:
 * 
 * [MessageType|integer, ... one or more message type specific elements ...]
 * 
 * The notation "Element|type" denotes a message element named "Element" of type "type", where "type" is one of
 * 
 * o "uri": a string URI as defined in Section 5.1.1
 * 
 * o "id": an integer ID as defined in Section 5.1.2
 * 
 * o "integer": a non-negative integer
 * 
 * o "string": a Unicode string, including the empty string
 * 
 * o "bool": a boolean value ("true" or "false") - integers MUST NOT be used instead of boolean value
 * 
 * o "dict": a dictionary (map) where keys MUST be strings, keys MUST be unique and serialization order is undefined (left to the serializer being used)
 * 
 * o "list": a list (array) where items can be again any of this enumeration
 * 
 * _Example_
 * 
 * A "SUBSCRIBE" message has the following format
 * 
 * [SUBSCRIBE, Request|id, Options|dict, Topic|uri]
 * 
 * Here is an example message conforming to the above format
 * 
 * [32, 713845233, {}, "com.myapp.mytopic1"]
 * 
 * @author nf11624
 *
 */
public abstract class Message {

	private MessageUtility messageUtility;

	protected JSONToken[] messageTokens;

	private Map<String, MessageElement<?>> messageElements;

	private String rawMessage;

	public Map<String, MessageElement<?>> getMessageElements() {
		return messageElements;
	}

	public void setMessageElements(Map<String, MessageElement<?>> messageElements) {
		this.messageElements = messageElements;
	}

	public void setRawMessage(String rawMessage) {
		this.rawMessage = rawMessage;
	}

	public String getRawMessage() {
		return rawMessage;
	}

	protected abstract JSONToken[] generateTokens(String messageText);

	protected abstract MessageBuilder getMessageBuilder();

	@Autowired
	public void setMessageUtility(MessageUtility messageUtility) {
		this.messageUtility = messageUtility;
	}

}
