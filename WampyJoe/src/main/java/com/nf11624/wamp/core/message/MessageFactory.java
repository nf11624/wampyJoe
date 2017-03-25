package com.nf11624.wamp.core.message;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.WebSocketMessage;

import com.nf11624.wamp.core.message.session.HelloMessage;

public class MessageFactory {

	private static final Logger logger = LoggerFactory.getLogger(MessageFactory.class);

	private static final Map<String, Class<? extends Message>> messageTypeMap;
	static {
		Map<String, Class<? extends Message>> typeMap = new HashMap<String, Class<? extends Message>>();
		typeMap.put("HELLO", HelloMessage.class);

		messageTypeMap = Collections.unmodifiableMap(typeMap);
	}

	public Message buildMessage(WebSocketMessage<?> wsMessage) {

		Message msg = null;

		Object payload = wsMessage.getPayload();

		if (payload.getClass().equals(String.class)) {
			try {
				msg = messageTypeMap.get("SomeKey").newInstance();
			} catch (InstantiationException e) {
				logger.error(e.getMessage(), e);
			} catch (IllegalAccessException e) {
				logger.error(e.getMessage(), e);
			}
		}

		return msg;

	}

	private MessageOperationPair<String, Integer> getMessageType(String payload) {
		StringBuilder sb = new StringBuilder(payload.length());
		MessageOperationPair<String, Integer> mop = null;
		char[] payloadAsArray = payload.toCharArray();
		for (int i = 0; i < payload.length(); i++) {
			sb.append(payloadAsArray[i]);
			if (payloadAsArray[i] == ',') {
				mop = new MessageOperationPair<String, Integer>(sb.toString(), i);
				break;
			}
		}
		return mop;
	}

	private List<MessageElement> fromStringPayload(String payload) {
		List<MessageElement> messageElements = new LinkedList<MessageElement>();
		char[] payloadAsArray = payload.toCharArray();
		boolean insideStringType = false;
		StringBuilder sb = new StringBuilder(payload.length());
		// MessageElement element = new MessageElement();
		for (int i = 0; i < payload.length(); i++) {
			if (payloadAsArray[i] == '"') {
				if (insideStringType) {

				} else {

				}
				insideStringType = true;
			} else {
				sb.append(payloadAsArray[i]);
			}
			if (insideStringType && payloadAsArray[i] == ',') {

			}
		}
		return messageElements;
	}

	private class MessageOperationPair<K extends String, V extends Integer> {

		private K k;
		private V v;

		public K getString() {
			return k;
		}

		public V getInt() {
			return v;

		}

		public MessageOperationPair(K k, V v) {
			this.k = k;
			this.v = v;
		}
	}
}
