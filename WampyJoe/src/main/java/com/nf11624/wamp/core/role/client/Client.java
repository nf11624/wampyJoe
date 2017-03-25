package com.nf11624.wamp.core.role.client;

import java.net.URI;

public interface Client {

	/**
	 * Make a call to a Router. The call can be a publish, subscribe or RPC call
	 * 
	 * @param uri
	 * @param objects
	 */
	public void call(URI uri, Object... objects);

	/**
	 * Execute a message from a Router.
	 * 
	 * @param uri
	 * @param objects
	 */
	public void execute(URI uri, Object... objects);
}
