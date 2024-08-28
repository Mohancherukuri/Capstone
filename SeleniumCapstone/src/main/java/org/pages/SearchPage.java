package org.pages;

import java.util.List;
import org.base.ElementActions;
import org.base.browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    ElementActions element = new ElementActions();
    
    public SearchPage() {
        PageFactory.initElements(browser.driver, this);
    }

    @FindBy(xpath = "//a[contains(@class, 'a-link-normal') and contains(@class, 's-underline-text')]")
    public List<WebElement> productItemsRow;

    public void switchToNewTab() {
        // Switch to the new tab
        String currentHandle = browser.driver.getWindowHandle();
        for (String handle : browser.driver.getWindowHandles()) {
            if (!handle.equals(currentHandle)) {
                browser.driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void returnNthElement(int number) throws InterruptedException {
        WebElement nthElement = productItemsRow.get(number - 1);
        ((JavascriptExecutor) browser.driver).executeScript("arguments[0].scrollIntoView(true);", nthElement);
        element.click(nthElement);
        switchToNewTab();
        // Optional: Scroll to the top of the page if needed
        Thread.sleep(2000);
        ((JavascriptExecutor) browser.driver).executeScript("window.scrollTo(0, 0);");
    }


    public void scrollAndClick(int number) {
        WebElement nthElement = productItemsRow.get(number - 1);
        ((JavascriptExecutor) browser.driver).executeScript("arguments[0].scrollIntoView(true);", nthElement);
        element.click(nthElement);
    }
}
