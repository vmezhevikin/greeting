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
public class Test_MessageUtil_FR {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Test_MessageUtil_FR.class);
	
	private String expectedMessage;
	private Integer hour;
	private Integer minute;
	private Integer second;
	
	public Test_MessageUtil_FR(String expectedMessage, Integer hour, Integer minute, Integer second) {
		this.expectedMessage = expectedMessage;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	@BeforeClass
	public static void beforeTest() {
		MessageUtil.setCurrentLanguage("fr");
		LOGGER.debug("Start testing MessageUtil.getGreetingMessageForTime(time) FR");
	}
	
	@Parameters(name = "test #{index} time: {1}:{2}:{3} expecting {0}")
	public static Collection<?> param()
	{
		return Arrays.asList(new Object[][] {
			{ "Bonne nuit", 0, 0, 0 },
			{ "Bonne nuit", 1, 0, 0 },
			{ "Bonne nuit", 2, 0, 0 },
			{ "Bonne nuit", 3, 0, 0 },
			{ "Bonne nuit", 4, 0, 0 },
			{ "Bonne nuit", 5, 0, 0 },
			{ "Bonne nuit", 5, 59, 59 },
			{ "Bonjour", 6, 0, 0 },
			{ "Bonjour", 6, 0, 1 },
			{ "Bonjour", 7, 0, 0 },
			{ "Bonjour", 8, 0, 0 },
			{ "Bonjour", 8, 59, 59 },
			{ "Bonne journée", 9, 0, 0 },
			{ "Bonne journée", 9, 0, 1 },
			{ "Bonne journée", 10, 0, 0 },
			{ "Bonne journée", 12, 0, 0 },
			{ "Bonne journée", 13, 0, 0 },
			{ "Bonne journée", 14, 0, 0 },
			{ "Bonne journée", 15, 0, 0 },
			{ "Bonne journée", 16, 0, 0 },
			{ "Bonne journée", 17, 0, 0 },
			{ "Bonne journée", 18, 0, 0 },
			{ "Bonne journée", 18, 59, 59 },
			{ "Bonsoir", 19, 0, 0 },
			{ "Bonsoir", 19, 0, 1 },
			{ "Bonsoir", 20, 0, 0 },
			{ "Bonsoir", 21, 0, 0 },
			{ "Bonsoir", 22, 0, 0 },
			{ "Bonsoir", 22, 59, 59 },
			{ "Bonne nuit", 23, 0, 0 },
			{ "Bonne nuit", 23, 0, 1 },
			{ "Bonne nuit", 23, 59, 0 } });
	}
	
	@Test
	public void testGetGreetingMessageForTime() {
		LocalTime time = LocalTime.of(hour, minute, second);
		String message = MessageUtil.getGreetingMessageForTime(time);
		LOGGER.debug("time: {} expecting {} - {}", TimeUtil.getTimeAsString(time), expectedMessage, expectedMessage.equals(message));
		assertEquals(expectedMessage, message);
	}
}