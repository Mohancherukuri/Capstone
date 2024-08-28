package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPageObject {
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public List<WebElement> productList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	public List<WebElement> productAddCartBtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement cartBtn;
	
	public ProductPageObject(AndroidDriver driver) {
        // Initialize elements with the driver using AppiumFieldDecorator
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
