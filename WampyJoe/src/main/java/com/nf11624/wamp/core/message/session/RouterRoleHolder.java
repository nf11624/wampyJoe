package com.nf11624.wamp.core.message.session;

public class RouterRoleHolder {

	private Object broker;
	private Object dealer;

	public Object getBroker() {
		return broker;
	}

	public Object getDealer() {
		return dealer;
	}

	public void setBroker(Object broker) {
		this.broker = broker;
	}

	public void setDealer(Object dealer) {
		this.dealer = dealer;
	}

	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if (obj instanceof RouterRoleHolder) {
			RouterRoleHolder holder2 = (RouterRoleHolder) obj;
			if (broker != null) {
				equals = broker.equals(holder2.broker);
			} else {
				equals = broker == holder2.broker;
			}
			if (dealer != null) {
				equals = dealer.equals(holder2.dealer);
			} else {
				equals = dealer == holder2.dealer;
			}
		}
		return equals;
	}

}
