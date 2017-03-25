package com.nf11624.wamp.core.message;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MessageBuilderPostProcessor implements BeanPostProcessor {

	private MessageBuilderRegistry messageBuilderRegistry;

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof MessageBuilder) {
			MessageBuilder builder = (MessageBuilder) bean;
			System.err.println("Registering : " + builder.getClass().getName());
			messageBuilderRegistry.register(builder.getMessageType(), builder);
		}
		return bean;
	}

	@Autowired
	public void setMessageBuilderRegistry(MessageBuilderRegistry messageBuilderRegistry) {
		this.messageBuilderRegistry = messageBuilderRegistry;
	}
}