package org.AppiumProject.PageObjects.android;

import java.util.List;

import org.AppiumProject.AndroidActions.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalog extends AndroidActions{
	
AndroidDriver driver;
	
	public ProductCatalog(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver; //to give life to the actual driver and expand the scope to local class
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartButton;
	
	
	//Adds to cart 
	public void addToCartByIndex(int index)
	{
		addToCart.get(index).click();
	}
	
	public CartPage goToCartPage()
	{
		cartButton.click();
		return new CartPage(driver);
	}
	


}
