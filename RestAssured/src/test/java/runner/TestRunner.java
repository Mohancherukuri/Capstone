package runner;

import base.BaseTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
    features = "D:\\Selenium\\RestAssured\\src\\test\\resources\\features\\todoFeature.feature", // Path to your feature files
    glue = "stepDefinations", // Package containing step definitions
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber-reports/Cucumber.json"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() {
        BaseTest baseTest = new BaseTest();
        baseTest.setup();
    }
}
