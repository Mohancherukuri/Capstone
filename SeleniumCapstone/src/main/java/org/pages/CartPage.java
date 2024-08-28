package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
	@FindBy(name="proceedToRetailCheckout")
	public WebElement proccedToBuyBtn;
	
	@FindBy(xpath ="//h2[normalize-space()=\"Shopping Cart\"]")
	public WebElement cartTitle;
	
	@FindBy(css="div[class=\"a-column a-span8\"] h1")
	public WebElement checkoutTitle;
}
