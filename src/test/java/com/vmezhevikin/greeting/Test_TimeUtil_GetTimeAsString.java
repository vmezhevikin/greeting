package com.vmezhevikin.greeting;

import static org.junit.Assert.assertTrue;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(value = Parameterized.class)
public class Test_TimeUtil_GetTimeAsString {

	private static final Logger LOGGER = LoggerFactory.getLogger(Test_TimeUtil_GetTimeAsString.class);

	private static Pattern pattern;

	private Integer hour;
	private Integer minute;

	public Test_TimeUtil_GetTimeAsString(Integer hour, Integer minute) {
		this.hour = hour;
		this.minute = minute;
	}

	@BeforeClass
	public static void beforeTest() {
		LOGGER.debug("Start testing TimeUtil.getTimeAsString()");
		pattern = Pattern.compile("[0-9]{2}:[0-9]{2}:[0-9]{2}");
	}

	@Parameters(name = "test #{index} time: {0}:{1} expecting format HH:mm:ss")
	public static Collection<?> param() {
		return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 }, { 4, 0 }, { 5, 0 }, { 5, 59 },
				{ 6, 0 }, { 6, 1 }, { 7, 0 }, { 8, 0 }, { 8, 59 }, { 9, 0 }, { 9, 1 }, { 10, 0 }, { 12, 0 }, { 13, 0 },
				{ 14, 0 }, { 15, 0 }, { 16, 0 }, { 17, 0 }, { 18, 0 }, { 18, 59 }, { 19, 0 }, { 19, 1 }, { 20, 0 },
				{ 21, 0 }, { 22, 0 }, { 22, 59 }, { 23, 0 }, { 23, 1 }, { 23, 59 } });
	}

	@Test
	public void testGetTimeAsString() {
		LocalTime time = LocalTime.of(hour, minute);
		String timeStr = TimeUtil.getTimeAsString(time);
		Matcher matcher = pattern.matcher(timeStr);
		boolean result = matcher.matches();
		LOGGER.debug("time {} matches HH:mm:ss - {}", timeStr, result);
		assertTrue(result);
	}
}