package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Actions {
	
	public void waitUntil(WebDriverWait wait, WebElement obj) {
		wait.until(ExpectedConditions.visibilityOf(obj));
	}

	public void click(WebDriverWait wait, WebElement obj) {
		waitUntil(wait,obj);
		obj.click();
	}

	public void sendKeys(WebDriverWait wait, WebElement obj,String text) {
		waitUntil(wait,obj);
		obj.sendKeys(text);
		
	}

	public void scrollAndClick(AndroidDriver driver, String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
            ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));

        // After scrolling, locate the element and click it
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"" + text + "\")"));
        element.click();
    }
	
	public void scrollTo(AndroidDriver driver, String text) {
		driver.findElement(AppiumBy.androidUIAutomator(
	            "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
	            ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
	}

}
