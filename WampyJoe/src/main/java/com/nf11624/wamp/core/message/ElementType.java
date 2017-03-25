package com.nf11624.wamp.core.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * o "uri": a string URI as defined in Section 5.1.1
 * 
 * o "id": an integer ID as defined in Section 5.1.2
 * 
 * o "integer": a non-negative integer
 * 
 * o "string": a Unicode string, including the empty string
 * 
 * o "bool": a boolean value ("true" or "false") - integers MUST NOT be used
 * instead of boolean value
 * 
 * o "dict": a dictionary (map) where keys MUST be strings, keys MUST be unique
 * and serialization order is undefined (left to the serializer being used)
 * 
 * o "list": a list (array) where items can be again any of this enumeration
 * 
 * @author nf11624
 *
 */
@Component
public class ElementType {

	private String value;

	@Value("${element.type.uri:uri}")
	private static String uri;

	@Value("${element.type.id:id}")
	private static String id;

	@Value("${element.type.integer:integer}")
	private static String integer;

	@Value("${element.type.string:string}")
	private static String string;

	@Value("${element.type.bool:bool}")
	private static String bool;

	@Value("${element.type.dict:dict}")
	private static String dict;

	@Value("${element.type.list:list}")
	private static String list;

	private ElementType(String value) {
		this.value = value;
	}

	public static ElementType URI = new ElementType(uri);
	public static ElementType ID = new ElementType(id);

}
