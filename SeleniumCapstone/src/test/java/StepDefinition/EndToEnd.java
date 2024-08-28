package StepDefinition;

import org.base.ElementActions;
import org.base.browser;
import org.openqa.selenium.support.PageFactory;
import org.pages.CartPage;
import org.pages.HomePage;
import org.pages.LoginPage;
import org.pages.ProductPage;
import org.pages.SearchPage;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EndToEnd {
	ElementActions element;
	HomePage homepage;
	SearchPage searchPage;
	ProductPage productPage;
	CartPage cartPage;
	LoginPage loginPage;
	
	public EndToEnd() {
		element = new ElementActions();
		homepage = PageFactory.initElements(browser.driver, HomePage.class);
		searchPage = PageFactory.initElements(browser.driver, SearchPage.class);
		productPage = PageFactory.initElements(browser.driver, ProductPage.class);
		cartPage =  PageFactory.initElements(browser.driver, CartPage.class);
		loginPage = PageFactory.initElements(browser.driver, LoginPage.class);
	}
	
	@Then("User Scrolls to a random product and click it {string}")
	public void user_scrolls_to_a_random_product_and_click_it(String number) throws InterruptedException {
	   searchPage.returnNthElement(3);
	   Thread.sleep(2000);
	}
	@And("User Checks the Product Title")
	public void user_checks_the_product_title() {
		Assert.assertTrue(element.isDisplayed(productPage.productTitle));
		
	}
	@Then("User Clicks on Add To Cart.")
	public void user_clicks_on_add_to_cart() {
	    element.click(productPage.addToCartBtn);
	}
	@Then("User Clicks on Cart Button Goes to Cart")
	public void user_clicks_on_cart_button_goes_to_cart() {
	    element.click(productPage.sideCartBtn);
	}
	@And("User sees the cart page")
	public void user_sees_the_cart_page() {
	 element.isDisplayed(cartPage.cartTitle);
	}
	@Then("User Presses on Proceed to Buy")
	public void user_presses_on_proceed_to_buy() {
		element.click(cartPage.proccedToBuyBtn);
	}
//	@And("User is Directed to SignIn Page")
//	public void user_is_directed_to_sign_in_page() {
//		element.isDisplayed(loginPage.title);
//		Assert.assertTrue(loginPage.title.getText().equals("Sign in"));
//	}
	@Then("User Fills {string}")
	public void user_fills(String phone) {
		element.sendKeys(loginPage.emailField, phone);
	}
	

	
	@Then("User Fills Password {string}")
	public void user_fills_password(String password) {
		element.sendKeys(loginPage.passwordField, password);
	}
	
	@And("User clicks on Continue Button")
	public void user_clicks_on_continue_button() {
		element.click(loginPage.continueBtn);
	}
	@And("User clicks on Sign In")
	public void user_clicks_on_sign_in() {
		element.click(loginPage.signInBtn);
	}
	@Then("User should see checkout Screen")
	public void user_should_see_checkout_screen() {
		element.isDisplayed(cartPage.checkoutTitle);
		Assert.assertTrue(cartPage.checkoutTitle.getText().equals("Checkout"));
	}
}
