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

import com.vmezhevikin.greeting.TimeUtil.DayTime;

@RunWith(value = Parameterized.class)
public class Test_TimeUtil_GetDayTime {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Test_TimeUtil_GetDayTime.class);
	
	private DayTime expected;
	private Integer hour;
	private Integer minute;
	private Integer second;
	
	public Test_TimeUtil_GetDayTime(DayTime expected, Integer hour, Integer minute, Integer second) {
		this.expected = expected;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	@BeforeClass
	public static void beforeTest() {
		LOGGER.debug("Start testing TimeUtil.getDayTime(time)");
	}
	
	@Parameters(name = "test #{index} time: {1}:{2}:{3} expecting {0}")
	public static Collection<?> param()
	{
		return Arrays.asList(new Object[][] {
			{ DayTime.NIGHT, 0, 0, 0 },
			{ DayTime.NIGHT, 1, 0, 0 },
			{ DayTime.NIGHT, 2, 0, 0 },
			{ DayTime.NIGHT, 3, 0, 0 },
			{ DayTime.NIGHT, 4, 0, 0 },
			{ DayTime.NIGHT, 5, 0, 0 },
			{ DayTime.NIGHT, 5, 59, 59 },
			{ DayTime.MORNING, 6, 0, 0 },
			{ DayTime.MORNING, 6, 0, 1 },
			{ DayTime.MORNING, 7, 0, 0 },
			{ DayTime.MORNING, 8, 0, 0 },
			{ DayTime.MORNING, 8, 59, 59 },
			{ DayTime.DAY, 9, 0, 0 },
			{ DayTime.DAY, 9, 0, 1 },
			{ DayTime.DAY, 10, 0, 0 },
			{ DayTime.DAY, 12, 0, 0 },
			{ DayTime.DAY, 13, 0, 0 },
			{ DayTime.DAY, 14, 0, 0 },
			{ DayTime.DAY, 15, 0, 0 },
			{ DayTime.DAY, 16, 0, 0 },
			{ DayTime.DAY, 17, 0, 0 },
			{ DayTime.DAY, 18, 0, 0 },
			{ DayTime.DAY, 18, 59, 59 },
			{ DayTime.EVENING, 19, 0, 0 },
			{ DayTime.EVENING, 19, 0, 1 },
			{ DayTime.EVENING, 20, 0, 0 },
			{ DayTime.EVENING, 21, 0, 0 },
			{ DayTime.EVENING, 22, 0, 0 },
			{ DayTime.EVENING, 22, 59, 59 },
			{ DayTime.NIGHT, 23, 0, 0 },
			{ DayTime.NIGHT, 23, 0, 1 },
			{ DayTime.NIGHT, 23, 59, 59 } });
	}
	
	@Test
	public void testGetDayTime() {
		LocalTime time = LocalTime.of(hour, minute, second);
		DayTime expectedDayTime = TimeUtil.getDayTime(time);
		LOGGER.debug("time: {} expecting day time {} - {}", TimeUtil.getTimeAsString(time), expectedDayTime, expectedDayTime.equals(expected));
		assertEquals(expected, expectedDayTime);
	}
}