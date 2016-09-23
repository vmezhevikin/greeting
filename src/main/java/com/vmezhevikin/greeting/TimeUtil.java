package com.vmezhevikin.greeting;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
	
	public enum DayTime {
		MORNING, DAY, EVENING, NIGHT 
	}

	private static final LocalTime MORNING_TIME = LocalTime.of(6, 0, 0);
	private static final LocalTime DAY_TIME = LocalTime.of(9, 0, 0);
	private static final LocalTime EVENING_TIME = LocalTime.of(19, 0, 0);
	private static final LocalTime NIGHT_TIME = LocalTime.of(23, 0, 0);
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

	/**
	 * @return current time from the system clock in the default time-zone
	 */
	public static LocalTime getCurrentTime() {
		return LocalTime.now();
	}

	/**
	 * @param time
	 * @return input time as String (HH:mm:ss)
	 */
	public static String getTimeAsString(LocalTime time) {
		return time.format(FORMATTER);
	}

	/**
	 * @param time
	 * @return DayTime.MORNING if time is 6:00-9:00; DayTime.DAY - 9:00-19:00; 
	 * DayTime.EVENING - 19:00-23:00; DayTime.NIGHT - 23:00-6:00
	 */
	public static DayTime getDayTime(LocalTime time) {
		if (time.isBefore(MORNING_TIME)) {
			return DayTime.NIGHT;
		} else if (time.isBefore(DAY_TIME)) {
			return DayTime.MORNING;
		} else if (time.isBefore(EVENING_TIME)) {
			return DayTime.DAY;
		} else if (time.isBefore(NIGHT_TIME)) {
			return DayTime.EVENING;
		}
		return DayTime.NIGHT;
	}
}