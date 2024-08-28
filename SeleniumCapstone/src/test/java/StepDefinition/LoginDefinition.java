package StepDefinition;

import static org.testng.Assert.assertTrue;

import org.base.ElementActions;
import org.base.browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pages.HomePage;
import org.pages.LoginPage;
import org.testng.Assert;
import org.utility.Wait;
import org.utility.propertiesRead;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginDefinition {
	ElementActions element;
	HomePage homepage;
	LoginPage login;
	@Given("User is on Home Page")
	public void user_is_on_home_page() throws Exception {
	   browser.setUp();
	   browser.getUrl(propertiesRead.properties("url"));
	   element =new ElementActions();
	   login = PageFactory.initElements(browser.driver, LoginPage.class);
	   homepage = PageFactory.initElements(browser.driver, HomePage.class);
	   
	    //Check if navbar is available in home page
	    element.isDisplayed(homepage.navShop);
	}

	@Then("User Navigates to Login Page")
	public void user_navigates_to_login_page() {
		element.hover(homepage.accountLists);
	    element.click(homepage.signUpBtn);
	}

	@And("User Fills the Login form with their {string} and {string}")
	public void user_fills_the_login_form_with_their_and(String email, String password) {
		
	    element.sendKeys(login.emailField, email);
	    element.click(login.continueBtn);
	    element.sendKeys(login.passwordField, password);
	}

	@And("User click on Login Button")
	public void user_click_on_login_button() {
		element.click(login.signInBtn);
	}

	@Then("User should see The Navbar")
	public void user_should_see_the_navbar() throws InterruptedException {
	    element.isDisplayed(homepage.navShop);
	}

	@Then("Close the Browser")
	public void close_the_browser() {
	   browser.driver.quit();
	}
	
	@Then("User Fills the Login form with their {string}")
	public void user_fills_the_login_form_with_their(String email) {
		element.sendKeys(login.emailField, email);
	}
	@Then("User click on Continue Button")
	public void user_click_on_continue_button() {
		element.click(login.continueBtn);
	}
	@Then("User should Fill the Password with {string}")
	public void user_should_fill_the_password_with(String password) {
		
	    element.sendKeys(login.passwordField, password);
	    element.click(login.signInBtn);
	}
	
	@Then("User should see Error Message")
	public void user_should_see_error_message() {
	    assertTrue(login.error.getText().equals("There was a problem"));
	}
	
	
}
