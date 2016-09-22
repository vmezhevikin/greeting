package com.vmezhevikin.greeting;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test_LanguageUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Test_LanguageUtil.class);
	
	@BeforeClass
	public static void beforeTest() {
		LOGGER.debug("Start testing LanguageUtil.getCurrentLanguage()");
	}
	
	@Test
	public void testGetCurrentLanguage1() {
		LanguageUtil.setDefaultLanguage();
		String language = LanguageUtil.getCurrentLanguage();
		String expected = "en";
		LOGGER.debug("Expecting {} as default language. Actual {}. Result {}", expected, language, expected.equals(language));
		assertEquals("Expecting " + expected + " as default language", expected, language);
	}
	
	@Test
	public void testGetCurrentLanguage2() {
		LanguageUtil.setDefaultLanguage();
		LanguageUtil.setCurrentLanguage("fr");
		String language = LanguageUtil.getCurrentLanguage();
		String expected = "fr";
		LOGGER.debug("Expecting {} as default language. Actual {}. Result {}", expected, language, expected.equals(language));
		assertEquals("Expecting " + expected + " as current language", expected, language);
	}
	
	@Test
	public void testGetCurrentLanguage3() {
		LanguageUtil.setDefaultLanguage();
		LanguageUtil.setCurrentLanguage("ru");
		String language = LanguageUtil.getCurrentLanguage();
		String expected = "ru";
		LOGGER.debug("Expecting {} as default language. Actual {}. Result {}", expected, language, expected.equals(language));
		assertEquals("Expecting " + expected + " as current language", expected, language);
	}
}