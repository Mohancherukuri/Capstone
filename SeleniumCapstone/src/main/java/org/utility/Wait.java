package org.utility;

import java.time.Duration;

import java.util.function.BooleanSupplier;

import org.base.browser;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	static int timeinSec = 30;

	public static void waitUntil(BooleanSupplier condition, int seconds) {
		new WebDriverWait(browser.driver, Duration.ofSeconds(seconds))
				.until((WebDriver driver) -> condition.getAsBoolean());
	}

	public static void waitUntil(BooleanSupplier condition) {
		waitUntil(condition, timeinSec);
	}

}