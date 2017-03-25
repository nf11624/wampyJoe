package com.nf11624.wamp.core.message;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.nf11624.wamp.core.message.json.MessageJSONTests;
import com.nf11624.wamp.core.message.session.MessageSessionTests;

@RunWith(Suite.class)
@SuiteClasses({ MessageJSONTests.class, MessageSessionTests.class })
public class CoreMessageTests {

}
