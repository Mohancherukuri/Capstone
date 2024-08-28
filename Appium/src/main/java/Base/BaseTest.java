package Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public static AndroidDriver driver;
    public static WebDriverWait wait;
    public static final Logger logger = LogManager.getLogger(BaseTest.class);
    
    @BeforeTest
    public void configureAppium() throws MalformedURLException {
    	
    	logger.info("Configuring Appium...");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setApp("D:/Selenium/Appium/src/test/resources/General-Store.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize wait
        logger.info("Appium configured successfully.");
    }
    
    @AfterMethod
    public void logTestResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error("Test " + result.getName() + " failed.");
            logger.error("Error: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.info("Test " + result.getName() + " passed.");
        }
    }

    @AfterTest
    public void closeApp() {
    	logger.info("Closing the app...");
        if (driver != null) {
            driver.quit();
            logger.info("App closed.");
        }
    }
}
