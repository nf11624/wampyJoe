package com.nf11624.wamp.core.message.json;

import java.util.InputMismatchException;

import org.springframework.beans.factory.annotation.Value;

public class JSONTokenizer {

	private char[] input;
	private StringBuilder tokenBuilder;
	private int currentIndex = 0;

	@Value("${json.token.delimiter::}")
	private final char delimiter = ':';
	@Value("${json.token.messageDelimiter:,}")
	private final char messageDelimiter = ',';

	public JSONTokenizer(String input) {
		this.input = input.trim().toCharArray();
		tokenBuilder = new StringBuilder(input.length());
	}

	public JSONToken nextToken() {
		JSONToken token = new JSONToken();
		boolean insideString = false;
		boolean isKey = true;
		int bracketCount = 0;
		int startIndex = tokenBuilder.length();

		for (; currentIndex < input.length; currentIndex++) {
			switch (input[currentIndex]) {
			case '"':
				insideString = !insideString;
				// input[currentIndex] = ' ';
				break;
			case '}':
				bracketCount--;
				break;
			case '{':
				bracketCount++;
				break;
			}
			if (bracketCount < 0 || (bracketCount != 0 && currentIndex == input.length - 1)) {
				throw new InputMismatchException("Illegal JSON input");
			}

			if (!insideString && bracketCount == 0 && (input[currentIndex] == delimiter
					|| input[currentIndex] == messageDelimiter || currentIndex == input.length - 1)) {
				// We want to include the last character when doing the value
				if (input[currentIndex] != delimiter && input[currentIndex] != messageDelimiter) {
					tokenBuilder.append(input[currentIndex]);
				}
				if (isKey == true) {
					if (input[currentIndex] != messageDelimiter) {
						isKey = false;
						token.setKey(tokenBuilder.substring(startIndex).trim());
						startIndex = tokenBuilder.length();
					} else { // This case is when there is no key
						token.setValue(tokenBuilder.substring(startIndex).trim());
						currentIndex++;
						break;
					}

				} else {
					// if (input[currentIndex] != delimiter && input[currentIndex] != messageDelimiter) {
					// tokenBuilder.append(input[currentIndex]);
					// }
					token.setValue(tokenBuilder.substring(startIndex).trim());
					currentIndex++;
					break; // Leave for loop
				}
			} else {
				tokenBuilder.append(input[currentIndex]);
			}
		}
		return token;
	}

	public boolean hasNext() {
		return !(currentIndex == input.length);
	}

}
