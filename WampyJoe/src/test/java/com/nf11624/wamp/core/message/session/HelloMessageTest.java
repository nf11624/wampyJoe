package com.nf11624.wamp.core.message.session;

import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nf11624.wamp.core.message.MessageBuilder;
import com.nf11624.wamp.core.message.MessageBuilderRegistry;
import com.nf11624.wamp.core.message.MessageElement;
import com.nf11624.wamp.core.message.session.definition.HelloMessageDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/application-context.xml" })
public class HelloMessageTest {

	private static String sampleMessage = "Hello,\"somerealm\", { \"roles\": { \"publisher\": {}, \"subscriber\": {} } }";
	private static URI sampleRealmURI = URI.create("somerealm");

	@Autowired
	MessageBuilderRegistry registry;

	@Test
	public void testGetFromPayload() {
		MessageBuilder<?> builder = registry.lookup(HelloMessage.class);
		HelloMessage message = (HelloMessage) builder.buildFromPayload(sampleMessage);
		Map<String, MessageElement<?>> elements = message.getMessageElements();
		assertTrue(elements.get("NAME").getValue().equals("Hello"));
		assertTrue(elements.get("REALM").getValue().equals(sampleRealmURI));

		HelloMessageDetails details = new HelloMessageDetails();
		ClientRoleHolder roleHolder = new ClientRoleHolder();
		roleHolder.setPublisher(new LinkedHashMap());
		roleHolder.setSubscriber(new LinkedHashMap());
		details.setRoles(roleHolder);

		elements.get("DETAILS");
		assertTrue(elements.get("DETAILS").getValue().equals(details));

	}

}
