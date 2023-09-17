package org.AppiumProject;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.AppiumProject.PageObjects.android.CartPage;
import org.AppiumProject.PageObjects.android.FormPage;
import org.AppiumProject.PageObjects.android.ProductCatalog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class CalculateTotal extends BaseTest {
	
//	@BeforeMethod
//	public void preSetup()
//	{
//		Fp.setActivity();
//	}
	
	@Test(dataProvider="getData")
	public void verifyTotalAmount( HashMap<String,String> input) throws InterruptedException
	{
		
		//FormPage Fp = new FormPage(driver);
		Fp.setNameField(input.get("name"));
		Fp.setGender(input.get("gender"));
		Fp.selectCountry(input.get("country"));
		ProductCatalog pg=Fp.submit();	
		pg.addToCartByIndex(0);
		pg.addToCartByIndex(0);
		CartPage Cp=pg.goToCartPage();
//		Cp.goToCart();
		double sum=Cp.calculateTotalPrice();
		double formattedAmt=Cp.validatePrice();
		Assert.assertEquals(sum, formattedAmt);
	}
	

	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"//src//main//java//org//AppiumProject//AndroidActions//json//Ecommerce.json");
				
//		return new Object[][] {{"Vaishali","Female","Argentina"},{"Vaibhav","Male","India"}};
		return new Object[][] {{data.get(0),data.get(1)}};
	}

	


		
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vaishali");
//		driver.hideKeyboard();
//		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
//		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
//		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
//		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
//		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
//		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
//		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//        double sum=0.0;
       
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		
//		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
//		Thread.sleep(5000);
		
//		List<WebElement>productPrices= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
//		
//		int count = productPrices.size();
//		
//		for(int i=0; i<count;i++)
//		{
//			String amount=productPrices.get(i).getText();
//			
//			double formattedTotalAmount =formattedAmount(amount);
//			
//			sum= sum+formattedTotalAmount;
//			
//		}
//		System.out.println(sum);
		
//		String totalDisplayedAmount=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
//		double totalDisplayedAmountFormatted=formattedAmount(totalDisplayedAmount);
//		System.out.println(totalDisplayedAmountFormatted);
//		Assert.assertEquals(sum, totalDisplayedAmountFormatted);
		
	}


