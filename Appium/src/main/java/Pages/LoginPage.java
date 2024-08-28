package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObjects.LoginPageObjects;
import Utilities.Actions;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
	Actions action = new Actions();
    LoginPageObjects obj;
    AndroidDriver driver;
    WebDriverWait wait;

    public LoginPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        obj = new LoginPageObjects(driver);  // Initialize Page Objects
    }

    public void handleLogin() {
    	action.sendKeys(wait, obj.name, "Mohan");
    	action.click(wait, obj.location);
    	action.scrollAndClick(driver, "Algeria");
    	action.click(wait,obj.maleRadio);
    	action.click(wait, obj.letGoBtn);
    }
    
    public void handleInvalidLogin() {
    	action.click(wait, obj.letGoBtn);
    	String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
    	Assert.assertEquals(toastMsg, "Please enter your name");
    }
    
}
