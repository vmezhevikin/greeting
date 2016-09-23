package com.vmezhevikin.greeting;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	private static void printGreetingForTime(LocalTime time) {
		String timeStr = TimeUtil.getTimeAsString(time);
		String message = MessageUtil.getGreetingMessageForTime(time);
		
		LOGGER.info("{} {}!", timeStr, message);
		System.out.println(timeStr + " " + message + "!");
	}
	
	public static void main(String[] args) {
		
		LocalTime time = TimeUtil.getCurrentTime();
		
		MessageUtil.setCurrentLanguage("en");
		printGreetingForTime(time);
		
		MessageUtil.setCurrentLanguage("fr");
		printGreetingForTime(time);
		
		MessageUtil.setCurrentLanguage("ru");
		printGreetingForTime(time);
		
		MessageUtil.setDefaultLanguage();
		printGreetingForTime(time);
	}
}