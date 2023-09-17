
package org.AppiumProject;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.AppiumProject.PageObjects.android.FormPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	 FormPage Fp;
	@BeforeTest
	public void configureAppium() throws MalformedURLException
	{
		 service	=new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Vaibhav Singh//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("0.0.0.0").usingPort(4723).build();
		service.start();
		//Thats how you have to start the Appium server programmatically
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("VaibhavEmulator");
		//options.setDeviceName("Android Device");
	//	options.setApp("C://Users//Vaibhav Singh//eclipse-workspace//Appium//src//test//java//resources//ApiDemos-debug.apk");
		options.setChromedriverExecutable("C://Users//Vaibhav Singh//Documents//chromedriver.exe");
		options.setApp("C://Users//Vaibhav Singh//eclipse-workspace//Appium//src//test//java//resources//General-Store.apk");
//		options.setCapability("androidInstallTimeout", 180000);
		 driver= new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  Fp = new FormPage(driver);
	}
	
	public static List<HashMap<String, String>> getJsonDataToMap( String filePath) throws IOException
	{
		//read json to String
		String jsonFormatFile =FileUtils.readFileToString(new File(filePath), 
				StandardCharsets.UTF_8);
		
		//Convert String to HashMap
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String,String>> data = mapper.readValue(jsonFormatFile, new TypeReference<List<HashMap<String,String>>>() {
			
		});
		return data;
	}
	
	
	public void longPress(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(), "duration",2000
			));
	}
	
	public void scrolltoEndSAction()
	{
boolean canScrollMore;
		
		do {
			 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					    "left", 100, "top", 100, "width", 200, "height", 200,
					    "direction", "down",
					    "percent", 3.0
					));
		}
		while(canScrollMore);
	}
	
	public void SwipeView(WebElement element,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	
	public double formattedAmount(String amount)
	{
		return Double.parseDouble(amount.substring(1));
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}

}
