package TestCase;

import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.ProductPage;

public class TestRunner extends BaseTest {

    @Test
    public void LoginTest() {
    	logger.info("Starting Invalid login test...");
        LoginPage page = new LoginPage(driver, wait);  // Pass driver and wait to the LoginPage
        page.handleLogin();
        logger.info("Invalid login test completed.");
    }
    
    @Test
    public void InvalidLogin() {
    	logger.info("Starting valid login test...");
    	LoginPage page = new LoginPage(driver, wait); 
    	page.handleInvalidLogin();
    	logger.info("Valid login test completed.");
    }
    
    @Test
    public void ProeductTesting() throws InterruptedException {
    	logger.info("Starting Product Page Testing...");
    	LoginPage page = new LoginPage(driver, wait);  // Pass driver and wait to the LoginPage
        page.handleLogin();
        ProductPage productPage = new ProductPage(driver, wait);
        productPage.selectProduct();
        logger.info("Product Page Test End");
    }
}
