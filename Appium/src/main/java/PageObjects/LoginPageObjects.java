package PageObjects;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

public class LoginPageObjects {

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public WebElement name;

    @AndroidFindBy(id="android:id/text1")
    public WebElement location;
    
    @AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
    public WebElement maleRadio;
    
    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    public WebElement letGoBtn;
    
    // Constructor
    public LoginPageObjects(AndroidDriver driver) {
        // Initialize elements with the driver using AppiumFieldDecorator
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
