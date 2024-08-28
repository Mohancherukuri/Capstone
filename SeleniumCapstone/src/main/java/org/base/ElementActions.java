package org.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.utility.Wait;

public class ElementActions {

	Actions action = new Actions(browser.driver);

	public boolean isDisplayed(WebElement element) {
		Wait.waitUntil(() -> element.isDisplayed());
		return element.isDisplayed();
	}

	public void click(WebElement element) {
		if (isDisplayed(element))
			element.click();

	}

	public void hover(WebElement element) {
		if (isDisplayed(element))
			action.moveToElement(element).perform();
	}

	public void sendKeys(WebElement element, String data) {
		if (isDisplayed(element))
			element.sendKeys(data);
	}
}
