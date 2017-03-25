package com.nf11624.wamp.core.message.element;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf11624.wamp.core.message.MessageDetails;

public class DictionaryElementBuilder implements ElementBuilder {

	public DictionaryElement buildDictionaryElement(String data, Class<? extends MessageDetails> messageDetailsClass) {
		DictionaryElement element = new DictionaryElement();
		ObjectMapper mapper = new ObjectMapper();
		MessageDetails details = null;
		try {
			details = mapper.readValue(data, messageDetailsClass);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element.setDetails(details);
		return element;
	}

}
