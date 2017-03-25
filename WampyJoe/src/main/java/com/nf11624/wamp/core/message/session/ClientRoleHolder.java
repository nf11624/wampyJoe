package com.nf11624.wamp.core.message.session;

public class ClientRoleHolder {
	private Object publisher;
	private Object subscriber;
	private Object caller;
	private Object callee;

	public Object getPublisher() {
		return publisher;
	}

	public Object getSubscriber() {
		return subscriber;
	}

	public Object getCaller() {
		return caller;
	}

	public Object getCallee() {
		return callee;
	}

	public void setPublisher(Object publisher) {
		this.publisher = publisher;
	}

	public void setSubscriber(Object subscriber) {
		this.subscriber = subscriber;
	}

	public void setCaller(Object caller) {
		this.caller = caller;
	}

	public void setCallee(Object callee) {
		this.callee = callee;
	}

	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if (obj instanceof ClientRoleHolder) {
			ClientRoleHolder holder2 = (ClientRoleHolder) obj;
			if (publisher != null) {
				equals = publisher.equals(holder2.publisher);
			} else {
				equals = publisher == holder2.publisher;
			}
			if (subscriber != null) {
				equals = subscriber.equals(holder2.subscriber);
			} else {
				equals = subscriber == holder2.subscriber;
			}
			if (callee != null) {
				equals = callee.equals(holder2.callee);
			} else {
				equals = callee == holder2.callee;
			}
			if (caller != null) {
				equals = caller.equals(holder2.caller);
			} else {
				equals = caller == holder2.caller;
			}
		}
		return equals;
	}
}
