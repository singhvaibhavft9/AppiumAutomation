package org.AppiumProject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class Ecommerce_Login extends BaseTest {
	
	
	@BeforeMethod
	public void preSetup()
	{
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
	//positive scenario
	@Test
	public void fillFormPositive() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vaishali");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMessage=driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		Assert.assertEquals(toastMessage,"Please enter your name");
		Thread.sleep(5000);
	}
	
	//negative scenario
	@Test
	public void fillFormNegative() throws InterruptedException
	{
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vaishali");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMessage=driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		Assert.assertEquals(toastMessage,"Please enter your name");
		Thread.sleep(5000);
	}

}
