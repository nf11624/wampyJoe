package com.nf11624.wamp.core.message.json;

public class JSONToken {

	private String key;
	private String value;

	public JSONToken() {

	}

	public JSONToken(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		if (value == null) {
			return key;
		}
		return value;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
