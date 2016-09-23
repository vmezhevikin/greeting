package com.vmezhevikin.greeting;

import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

import com.vmezhevikin.greeting.TimeUtil.DayTime;

public class MessageUtil {
	
	private static ResourceBundle resourceBoundle;
	
	/**
	 * reads messages from .properties file according to default language
	 */
	public static void setDefaultLanguage() {
		Locale locale = Locale.getDefault();
		resourceBoundle = ResourceBundle.getBundle("i18n.messages", locale);
	}
	
	/**
	 * reads messages from .properties file according to current language
	 * 
	 * @see {@link java.util.Locale}
	 */
	public static void setCurrentLanguage(String language) {
		Locale locale = new Locale(language);
		resourceBoundle = ResourceBundle.getBundle("i18n.messages", locale);
	}
	
	/**
	 * @param time Examples: "en", "fr", "ru"
	 * @return message for input time according to current language 
	 * (for "en": "Good morning" if time is 6:00-9:00; "Good day" - 9:00-19:00; 
	 * "Good evening" - 19:00-23:00; "Good night" - 23:00-6:00)
	 * @see {@link java.util.Locale}
	 */
	public static String getGreetingMessageForTime(LocalTime time) {
		DayTime dayTime = TimeUtil.getDayTime(time);
		return resourceBoundle.getString(dayTime.name());
	}
}