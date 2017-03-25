package com.nf11624.wamp.core.identifier;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;

import com.nf11624.wamp.core.session.WAMPSession;

@Scope("Singleton")
public class IDGenerator {

	private Map<WAMPSession, Integer> seeds = new HashMap<WAMPSession, Integer>();

	private int globalSeed = 1;

	public RouterID generateRouterId() {
		return null;
	}

	public SessionID generateSessionId(WAMPSession session) {
		SessionID sessionID = new SessionID();
		int seed = 0;
		if (seeds.containsKey(session)) {
			seed = seeds.get(session);
		}
		seed++;
		seeds.put(session, seed);
		sessionID.setValue(seed);
		return sessionID;
	}

	public GlobalID generateGlobalId() {
		return null;
	}

	private void getSeed() {

	}

}
