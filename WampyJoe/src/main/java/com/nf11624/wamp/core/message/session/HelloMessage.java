package com.nf11624.wamp.core.message.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nf11624.wamp.core.message.Message;
import com.nf11624.wamp.core.message.MessageBuilder;
import com.nf11624.wamp.core.message.json.JSONToken;
import com.nf11624.wamp.core.message.json.JSONTokenizer;

/*
 * 6.4.1.1.  HELLO

   Sent by a Client to initiate opening of a WAMP session to a Router
   attaching to a Realm.

       [HELLO, Realm|uri, Details|dict]
 */
public class HelloMessage extends Message {

	private static final Logger logger = LoggerFactory.getLogger(HelloMessage.class);

	// @Value("${message.hello.field.number:3}")
	private int numTokens = 3;

	// Field assignments, zero indexed
	public static enum Field {
		Name, Realm, Details
	}

	@Override
	public JSONToken[] generateTokens(String messageText) {
		JSONTokenizer tokenizer = new JSONTokenizer(messageText);
		JSONToken[] messageTokens = new JSONToken[numTokens];
		for (int i = 0; i < numTokens; i++) {
			messageTokens[i] = tokenizer.nextToken();
		}
		return messageTokens;
	}

	@Override
	protected MessageBuilder getMessageBuilder() {
		return null;
	}

}
