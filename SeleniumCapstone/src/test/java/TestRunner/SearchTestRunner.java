package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src//test//resources//Feature//Search.feature",
glue = { "StepDefinition"},  monochrome=true,
plugin = { "pretty","html:target/Cucumber/htmlreports.html",
		"json:target/JSON/Reports.json"}
)
public class SearchTestRunner extends AbstractTestNGCucumberTests {

}
