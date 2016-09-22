package com.vmezhevikin.greeting;

import java.util.Locale;

public class LanguageUtil {
	
	private static String currentLanguage = Locale.getDefault().getLanguage();
	
	/**
	 * @return Returns the language code of this Locale
	 */
	public static String getCurrentLanguage() {
		return currentLanguage;
	}
	
	/**
	 * Sets up the language code
	 * 
	 * @param language language code
	 */
	public static void setCurrentLanguage(String language) {
		currentLanguage = language;
	}
	
	/**
	 * Sets up the language code of this Locale
	 * 
	 * @see {@link java.util.Locale}
	 */
	public static void setDefaultLanguage() {
		currentLanguage = Locale.getDefault().getLanguage();
	}
}