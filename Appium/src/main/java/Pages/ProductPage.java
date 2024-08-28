package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageObjects.ProductPageObject;
import PageObjects.LoginPageObjects;
import Utilities.Actions;
import io.appium.java_client.android.AndroidDriver;

public class ProductPage {
	Actions action = new Actions();
    LoginPageObjects loginObject;
    
    ProductPageObject productObj;
    AndroidDriver driver;
    WebDriverWait wait;
    
    public ProductPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;  // Initialize Page Objects
        productObj = new  ProductPageObject(driver);
    }
    
    public void selectProduct() throws InterruptedException {

    	action.scrollTo(driver, "Jordan 6 Rings");
    	int productCount = productObj.productList.size();
    
    	for(int i=0;i<productCount;i++) {
    		String productName = productObj.productList.get(i).getText();
    		if(productName.equalsIgnoreCase("Jordan 6 Rings")) {
    	
//    			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
    			action.click(wait, productObj.productAddCartBtn.get(i));
    			
    		}
    	}
    	productObj.cartBtn.click();
    	Thread.sleep(2000);
    	
    	
    }
    
    public void clickOnCart() {
    	action.click(wait, productObj.cartBtn);
    }
}
