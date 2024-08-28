package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
	
	@FindBy(id="productTitle")
	public WebElement productTitle;
	
	@FindBy(xpath="//div[@class=\"a-section a-spacing-none a-padding-none\"]//input[@id=\"add-to-cart-button\"]")
	public WebElement addToCartBtn;
	
	@FindBy(xpath="//input[@aria-labelledby=\"attach-sidesheet-view-cart-button-announce\"]")
	public WebElement sideCartBtn;
}
