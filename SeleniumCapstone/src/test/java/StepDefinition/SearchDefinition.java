package StepDefinition;

import org.base.ElementActions;
import org.base.browser;
import org.pages.HomePage;
import org.pages.SearchPage;
import org.testng.Assert;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SearchDefinition {
	ElementActions element;
	HomePage homepage;
	SearchPage searchPage;

	public SearchDefinition() {
		element = new ElementActions();
		homepage = PageFactory.initElements(browser.driver, HomePage.class);
		searchPage = PageFactory.initElements(browser.driver, SearchPage.class);
	}

	@Then("User Searchs for {string} and presses search icon")
	public void user_searchs_for(String searchTerm) {
		element.sendKeys(homepage.searchBox, searchTerm);
		element.click(homepage.searchBtn);
	}

	@And("User Sees List of Products")
	public void user_sees_list_of_products() {
	    Assert.assertTrue(element.isDisplayed(homepage.resultTitle));
	    Assert.assertTrue(homepage.resultTitle.getText().equals("Results"));
	}

	@Then("User Scrolls to the third Product")
	public void user_selects_the_third_product() throws InterruptedException {
		searchPage.returnNthElement(3);
		Thread.sleep(2000);
	}


	@Then("User Closes the Browser")
	public void user_closes_the_browser() throws InterruptedException {
		browser.driver.quit();
	}
}
