package com.nf11624.wamp.core.message.json;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.InputMismatchException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/application-context.xml" })
public class JSONTokenizerTest {

	public static final String testInput = "\"key\" : { subkey1 : value1, subkey2 : value2 }";
	public static final String testMessage = "\"value\", \"key\" : {subkey : value}, \"key2\" : {}";
	public static final String testMessageWithNestedJSON = "\"value\", \"key\": {\"subkey\" : { \"subsubkey\" : \"value\" }, \"subkey2\" : \"value\" }, \"key2\" : {}";
	public static final String testMessageUnbalancedFront = "\"value\", \"key\" : {subkey : value2";
	public static final String testMessageUnbalancedBack = "\"value\", \"key\" : }";
	public static final String testMessageWithQuotedStrings = "\"key\" : \"value\", \"key2\" : { }";
	public static final String testMessageWithEndMap = "\"key\" : \"value\", { \"subkey\" : { \"subsubkey\" : \"subsubval\" } }";

	@Test
	public void testNextToken() {
		JSONTokenizer tokenizer = new JSONTokenizer(testInput);
		JSONToken token = tokenizer.nextToken();
		assertTrue(token.getKey().equals("\"key\""));
		assertTrue(token.getValue().equals("{ subkey1 : value1, subkey2 : value2 }"));

	}

	@Test
	public void testNextTokenOnMessage() {
		JSONTokenizer tokenizer = new JSONTokenizer(testMessage);
		JSONToken token = tokenizer.nextToken();
		assertTrue(token.getKey() == null);
		assertTrue(token.getValue().equals("\"value\""));
		token = tokenizer.nextToken();
		assertTrue(token.getKey().equals("\"key\""));
		assertTrue(token.getValue().equals("{subkey : value}"));
		token = tokenizer.nextToken();
		assertTrue(token.getKey().equals("\"key2\""));
		assertTrue(token.getValue().equals("{}"));
	}

	@Test
	public void testNextTokenOnNestedMessage() {
		JSONTokenizer tokenizer = new JSONTokenizer(testMessageWithNestedJSON);
		JSONToken token = tokenizer.nextToken();
		assertTrue(token.getKey() == null);
		assertTrue(token.getValue().equals("\"value\""));
		token = tokenizer.nextToken();
		assertTrue(token.getKey().equals("\"key\""));
		assertTrue(token.getValue().equals("{\"subkey\" : { \"subsubkey\" : \"value\" }, \"subkey2\" : \"value\" }"));
		token = tokenizer.nextToken();
		assertTrue(token.getKey().equals("\"key2\""));
		assertTrue(token.getValue().equals("{}"));
	}

	@Test
	public void testNextTokenOnMessageWithQuotedStrings() {
		JSONTokenizer tokenizer = new JSONTokenizer(testMessageWithQuotedStrings);
		JSONToken token = tokenizer.nextToken();
		assertTrue(token.getKey().equals("\"key\""));
		assertTrue(token.getValue().equals("\"value\""));
		token = tokenizer.nextToken();
		assertTrue(token.getKey().equals("\"key2\""));
		assertTrue(token.getValue().equals("{ }"));
	}

	@Test(expected = InputMismatchException.class)
	public void testNextTokenOnUnbalancedFrontMessage() {
		JSONTokenizer tokenizer = new JSONTokenizer(testMessageUnbalancedFront);
		JSONToken token = tokenizer.nextToken();
		token = tokenizer.nextToken();
	}

	@Test(expected = InputMismatchException.class)
	public void testNextTokenOnUnbalancedBackMessage() {
		JSONTokenizer tokenizer = new JSONTokenizer(testMessageUnbalancedBack);
		JSONToken token = tokenizer.nextToken();
		token = tokenizer.nextToken();
	}

	@Test
	public void testHasNext() {
		JSONTokenizer tokenizer = new JSONTokenizer(testMessage);
		assertTrue(tokenizer.hasNext());
		JSONToken token = tokenizer.nextToken();
		assertTrue(tokenizer.hasNext());
		token = tokenizer.nextToken();
		assertTrue(tokenizer.hasNext());
		token = tokenizer.nextToken();
		assertFalse(tokenizer.hasNext());
	}

	@Test
	public void testEndingMap() {
		JSONTokenizer tokenizer = new JSONTokenizer(testMessageWithEndMap);
		JSONToken token = tokenizer.nextToken();
		token = tokenizer.nextToken();
		// "\"key\" : \"value\", { \"subkey\" : { \"subsubkey\" : \"subsubval\" } }"
		assertTrue(token.getKey().equals("{ \"subkey\" : { \"subsubkey\" : \"subsubval\" } }"));

	}
}
