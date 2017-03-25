package com.nf11624.wamp.core.message;

import org.springframework.beans.factory.annotation.Autowired;

import com.nf11624.wamp.core.message.element.DictionaryElementBuilder;

public abstract class MessageBuilder<T extends Message> {

	protected DictionaryElementBuilder dictionaryElementBuilder;

	public abstract Message buildFromPayload(String payload);

	public abstract Class<? extends Message> getMessageType();

	@Autowired
	public final void setDictionaryElementBuilder(DictionaryElementBuilder dictionaryElementBuilder) {
		this.dictionaryElementBuilder = dictionaryElementBuilder;
	}
}
