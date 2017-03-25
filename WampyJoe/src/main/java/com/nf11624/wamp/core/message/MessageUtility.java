package com.nf11624.wamp.core.message;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MessageUtility {

	private static Logger logger = LoggerFactory.getLogger(MessageUtility.class);

	@SuppressWarnings("unchecked")
	public MessageDetails buildMessageDetails(String json, Class<? extends MessageDetails> detailsClass) {
		ObjectMapper mapper = new ObjectMapper();
		MessageDetails details = null;
		try {
			details = mapper.readValue(json, detailsClass);
		} catch (JsonParseException e) {
			logger.error(e.getMessage(), e);
		} catch (JsonMappingException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return details;
	}

}
