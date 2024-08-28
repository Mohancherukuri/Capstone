package org.pages;



import org.base.browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	public LoginPage() {
		PageFactory.initElements(browser.driver, this);
	}
	
	@FindBy(name="email")
	public WebElement emailField;
	
	@FindBy(id="continue")
	public WebElement continueBtn;
	
	@FindBy(name="password")
	public WebElement passwordField;
	
	@FindBy(id="signInSubmit")
	public WebElement signInBtn;

	@FindBy(css="div[id=\"auth-error-message-box\"] h4[class=\"a-alert-heading\"]")
	public WebElement error;
	
	@FindBy(xpath="//h2[normalize-space()=\"Shopping Cart\"]")
	public WebElement title;
}
