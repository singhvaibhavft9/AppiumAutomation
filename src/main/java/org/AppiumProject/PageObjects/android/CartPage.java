package org.AppiumProject.PageObjects.android;

import java.time.Duration;
import java.util.List;

import org.AppiumProject.AndroidActions.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {
	
AndroidDriver driver;
	
	public CartPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver; //to give life to the actual driver and expand the scope to local class
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement CartButtonToolBar;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrices;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	
	

	

	
//	public void goToCart() throws InterruptedException
//	{
//		wait.until(ExpectedConditions.attributeContains(CartButtonToolBar, "text", "Cart"));
//		Thread.sleep(5000);
//	}
	
	public double calculateTotalPrice()
	{
       int count = productPrices.size();
       double sum=0.0;
		
		for(int i=0; i<count;i++)
		{
			String amount=productPrices.get(i).getText();
			
			double formattedTotalAmount =formattedAmount(amount);
			
			sum= sum+formattedTotalAmount;
			
			
		}
		return sum;
	}
	
	
	public double validatePrice()
	{
		String totalDisplayedAmount=totalAmount.getText();
		double totalDisplayedAmountFormatted=formattedAmount(totalDisplayedAmount);
		return totalDisplayedAmountFormatted;
		
	}

}
