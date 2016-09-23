package com.vmezhevikin.greeting;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(value = Parameterized.class)
public class Test_MessageUtil_EN {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Test_MessageUtil_EN.class);
	
	private String expectedMessage;
	private Integer hour;
	private Integer minute;
	private Integer second;
	
	public Test_MessageUtil_EN(String expectedMessage, Integer hour, Integer minute, Integer second) {
		this.expectedMessage = expectedMessage;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	@BeforeClass
	public static void beforeTest() {
		MessageUtil.setCurrentLanguage("en");;
		LOGGER.debug("Start testing MessageUtil.getGreetingMessageForTime(time) EN");
	}
	
	@Parameters(name = "test #{index} time: {1}:{2}:{3} expecting {0}")
	public static Collection<?> param()
	{
		return Arrays.asList(new Object[][] {
			{ "Good night", 0, 0, 0 },
			{ "Good night", 1, 0, 0 },
			{ "Good night", 2, 0, 0 },
			{ "Good night", 3, 0, 0 },
			{ "Good night", 4, 0, 0 },
			{ "Good night", 5, 0, 0 },
			{ "Good night", 5, 59, 59 },
			{ "Good morning", 6, 0, 0 },
			{ "Good morning", 6, 0, 1 },
			{ "Good morning", 7, 0, 0 },
			{ "Good morning", 8, 0, 0 },
			{ "Good morning", 8, 59, 59 },
			{ "Good day", 9, 0, 0 },
			{ "Good day", 9, 0, 1 },
			{ "Good day", 10, 0, 0 },
			{ "Good day", 12, 0, 0 },
			{ "Good day", 13, 0, 0 },
			{ "Good day", 14, 0, 0 },
			{ "Good day", 15, 0, 0 },
			{ "Good day", 16, 0, 0 },
			{ "Good day", 17, 0, 0 },
			{ "Good day", 18, 0, 0 },
			{ "Good day", 18, 59, 59 },
			{ "Good evening", 19, 0, 0 },
			{ "Good evening", 19, 0, 1 },
			{ "Good evening", 20, 0, 0 },
			{ "Good evening", 21, 0, 0 },
			{ "Good evening", 22, 0, 0 },
			{ "Good evening", 22, 59, 59 },
			{ "Good night", 23, 0, 0 },
			{ "Good night", 23, 0, 1 },
			{ "Good night", 23, 59, 59 } });
	}
	
	@Test
	public void testGetGreetingMessageForTime() {
		LocalTime time = LocalTime.of(hour, minute, second);
		String message = MessageUtil.getGreetingMessageForTime(time);
		LOGGER.debug("time: {} expecting {} - {}", TimeUtil.getTimeAsString(time), expectedMessage, expectedMessage.equals(message));
		assertEquals(expectedMessage, message);
	}
}