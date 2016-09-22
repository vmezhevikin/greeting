package com.vmezhevikin.greeting;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import com.vmezhevikin.greeting.TimeUtil.DayTime;

public class MessageUtil {
	
	private static Map<DayTime, String> messages;
	
	/**
	 * reads messages from messages.properties file according to current language set in LanguageUtil
	 */
	public static void readMessagesForCurrentLanguage() {
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = App.class.getClassLoader().getResourceAsStream("i18n/messages.properties");
			properties.load(inputStream);
			messages = readMessages(properties, LanguageUtil.getCurrentLanguage());
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static Map<DayTime, String> readMessages(Properties properties, String language) {
		Map<DayTime, String> messages = new TreeMap<DayTime, String>();
		messages.put(DayTime.MORNING, properties.getProperty(language + ".greeting.morning"));
		messages.put(DayTime.DAY, properties.getProperty(language + ".greeting.day"));
		messages.put(DayTime.EVENING, properties.getProperty(language + ".greeting.evening"));
		messages.put(DayTime.NIGHT, properties.getProperty(language + ".greeting.night"));
		return messages;
	}
	
	/**
	 * @param time
	 * @return message for input time according to current language 
	 * (for "en": "Good morning" if time is 6:00-9:00; "Good day" - 9:00-19:00; 
	 * "Good evening" - 19:00-23:00; "Good night" - 23:00-6:00)
	 */
	public static String getGreetingMessageForTime(LocalTime time) {
		DayTime dayTime = TimeUtil.getDayTime(time);
		return messages.get(dayTime);
	}
}