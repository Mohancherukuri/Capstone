package org.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utility.DemoLog;
import org.utility.propertiesRead;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class browser {
	public static WebDriver driver; // Declared driver object globally
	public static WebDriverWait wait;
	public static ExtentReports extent = new ExtentReports();
	public static ExtentSparkReporter reporter = new ExtentSparkReporter(
			System.getProperty("user.dir") + "//target//ExtentReports//Report1.html");
	public static ExtentTest logger;

	public static void setUp() throws Exception {
		extent.attachReporter(reporter);
		logger = extent.createTest("Browser Selection");
		logger.log(Status.INFO, "Opening the Browser");
		try {
			String choice = propertiesRead.properties("browser");
			DemoLog.sample(1);
			if (choice.equalsIgnoreCase("Chrome")) {
				DemoLog.sample(6);
				logger.log(Status.PASS, "Brower Selection Passed");
				browser.chromeDriver();
			} else if (choice.equalsIgnoreCase("Edge")) {
				DemoLog.sample(6);
				logger.log(Status.PASS, "Brower Selection Passed");
				browser.edgeDriver();
			} else
				throw new Exception("Browser Error");
		} catch (Exception e) {
			DemoLog.sample(3);
			System.out.print(e);
			logger.log(Status.FAIL, "Browser Selection Failed");
		}
		extent.flush();
	}

	/*
	 * Opens the Chrome Browser
	 */
	public static void chromeDriver() {
		extent.attachReporter(reporter);
		logger = extent.createTest("Chrome Browser");
		logger.log(Status.INFO, "Opening the Browser");
		try {
			
			driver = new ChromeDriver();

			logger.log(Status.PASS, "Chrome Browser Intiated");
		} catch (Exception e) {
			System.out.print(e);
			logger.log(Status.FAIL, "Browser Intiation Failed");
		}
		extent.flush();
	}

	/*
	 * Opens the Edge Browser
	 */
	static void edgeDriver() {
		DemoLog.sample(2);
		extent.attachReporter(reporter);
		logger = extent.createTest("Edge Browser");
		logger.log(Status.INFO, "Opening the Browser");
		try {
			
			driver = new EdgeDriver();
		
			logger.log(Status.PASS, "Edge Browser Intiated");
		} catch (Exception e) {
		
			System.out.print(e);
			logger.log(Status.FAIL, "Browser Intiation Failed");
		}
		extent.flush();
	}

	/*
	 * Pauses the URL of the application
	 */
	public static void getUrl(String url) {
	
		extent.attachReporter(reporter);
		logger = extent.createTest("Loading Web-Application");
		logger.log(Status.INFO, "Opening the Application in Browser");
		try {
		
			driver.manage().window().maximize();
			driver.get(url);
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			logger.log(Status.PASS, "Web-Application Loaded Successfully");
		} catch (Exception e) {
	
			System.out.print(e);
			logger.log(Status.FAIL, "Web-Application Loading Failed");
		}
		extent.flush();
	}

	/*
	 * Closes the Browser
	 */
	public static void closeBrowser() {
		DemoLog.sample(2);
		extent.attachReporter(reporter);
		logger = extent.createTest("Close Browser");
		logger.log(Status.INFO, "Closing the Browser");
		try {
			DemoLog.sample(1);
			driver.quit();
			DemoLog.sample(6);
			logger.log(Status.PASS, "Browser Closed Successfully");
		} catch (Exception e) {
			DemoLog.sample(3);
			System.out.print(e);
			logger.log(Status.FAIL, "Browser Closing Failed");
		}
		extent.flush();
	}
}
