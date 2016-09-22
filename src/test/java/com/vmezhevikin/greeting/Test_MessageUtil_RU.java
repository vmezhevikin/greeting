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
public class Test_MessageUtil_RU {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Test_MessageUtil_RU.class);
	
	private String expectedMessage;
	private Integer hour;
	private Integer minute;
	
	public Test_MessageUtil_RU(String expectedMessage, Integer hour, Integer minute) {
		this.expectedMessage = expectedMessage;
		this.hour = hour;
		this.minute = minute;
	}
	
	@BeforeClass
	public static void beforeTest() {
		LanguageUtil.setCurrentLanguage("ru");
		MessageUtil.readMessagesForCurrentLanguage();
		LOGGER.debug("Start testing MessageUtil.getGreetingMessageForTime(time) EN");
	}
	
	@Parameters(name = "test #{index} time: {1}:{2} expecting {0}")
	public static Collection<?> param()
	{
		return Arrays.asList(new Object[][] {
			{ "Доброй ночи", 0, 0 },
			{ "Доброй ночи", 1, 0 },
			{ "Доброй ночи", 2, 0 },
			{ "Доброй ночи", 3, 0 },
			{ "Доброй ночи", 4, 0 },
			{ "Доброй ночи", 5, 0 },
			{ "Доброй ночи", 5, 59 },
			{ "Доброе утро", 6, 0 },
			{ "Доброе утро", 6, 1 },
			{ "Доброе утро", 7, 0 },
			{ "Доброе утро", 8, 0 },
			{ "Доброе утро", 8, 59 },
			{ "Добрый день", 9, 0 },
			{ "Добрый день", 9, 1 },
			{ "Добрый день", 10, 0 },
			{ "Добрый день", 12, 0 },
			{ "Добрый день", 13, 0 },
			{ "Добрый день", 14, 0 },
			{ "Добрый день", 15, 0 },
			{ "Добрый день", 16, 0 },
			{ "Добрый день", 17, 0 },
			{ "Добрый день", 18, 0 },
			{ "Добрый день", 18, 59 },
			{ "Добрый вечер", 19, 0 },
			{ "Добрый вечер", 19, 1 },
			{ "Добрый вечер", 20, 0 },
			{ "Добрый вечер", 21, 0 },
			{ "Добрый вечер", 22, 0 },
			{ "Добрый вечер", 22, 59 },
			{ "Доброй ночи", 23, 0 },
			{ "Доброй ночи", 23, 1 },
			{ "Доброй ночи", 23, 59 } });
	}
	
	@Test
	public void testGetGreetingMessageForTime() {
		LocalTime time = LocalTime.of(hour, minute);
		String message = MessageUtil.getGreetingMessageForTime(time);
		LOGGER.debug("time: {} expecting {} - {}", TimeUtil.getTimeAsString(time), expectedMessage, expectedMessage.equals(message));
		assertEquals(expectedMessage, message);
	}
}