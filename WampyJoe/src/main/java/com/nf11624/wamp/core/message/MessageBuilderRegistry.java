package com.nf11624.wamp.core.message;

import java.util.HashMap;
import java.util.Map;

public class MessageBuilderRegistry {

	private static final Map<Class<? extends Message>, MessageBuilder<? extends Message>> registry = new HashMap<Class<? extends Message>, MessageBuilder<? extends Message>>();;

	public MessageBuilder<?> lookup(Class<? extends Message> clazz) {
		return registry.get(clazz);
	}

	public void register(Class<? extends Message> clazz, MessageBuilder<?> builder) {
		registry.put(clazz, builder);
	}
}
