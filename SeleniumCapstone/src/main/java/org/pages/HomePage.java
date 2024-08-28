package org.pages;

import org.base.browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage() {
		PageFactory.initElements(browser.driver, this);
	}
	
	@FindBy(css="#nav-xshop")
	public WebElement navShop;
	
	@FindBy(id="nav-link-accountList")
	public WebElement accountLists;
	
	@FindBy(css="div[id=\"nav-flyout-ya-signin\"] span[class=\"nav-action-inner\"]")
	public WebElement signUpBtn;
	
	@FindBy(css="div[id=\"nav-signin-tooltip\"] span[class=\"nav-action-inner\"]")
	public WebElement hoverSignUpBtn;
	
	@FindBy(id="twotabsearchtextbox")
	public WebElement searchBox;
	
	@FindBy(id="nav-search-submit-button")
	public WebElement searchBtn;
	
	@FindBy(xpath="//h2[normalize-space()=\"Results\"]")
	public WebElement resultTitle;
	
}
