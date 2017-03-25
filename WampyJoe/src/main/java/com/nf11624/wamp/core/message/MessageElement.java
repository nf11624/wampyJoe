package com.nf11624.wamp.core.message;

public abstract class MessageElement<T extends Object> {

	protected ElementType type;

	protected T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public ElementType getType() {
		return type;
	}

	public void setType(ElementType type) {
		this.type = type;
	}

}
