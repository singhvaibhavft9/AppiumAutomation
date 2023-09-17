package org.AppiumProject.PageObjects.android;

import org.AppiumProject.AndroidActions.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vaishali");
	
	// you need to have driver in this class, for that we need the driver scope from Base Test
	//This can be easily done by constructor
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver; //to give life to the actual driver and expand the scope to local class
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void setActivity()
	{
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
	

	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleCandidate;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleCandidate;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countrySelection;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
  

	
    public void setNameField(String name)
    {
    	nameField.sendKeys(name);
    	driver.hideKeyboard();
    }
    
    public void setGender(String gender)
    {
    	if(gender.equalsIgnoreCase("Female"))
    	{
    		femaleCandidate.click();
    	}
    	else if(gender.equalsIgnoreCase("Male")) {
    		maleCandidate.click();
    	}
    	else {
    		Assert.fail("Please select the Gender");
    	}
    }
    
    
    public void selectCountry(String countryName)
    {
    	countrySelection.click();
    	scrollIntoText(countryName);	
    	driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
    }
    
    public ProductCatalog submit()
    {
    	shopButton.click();
    	return new ProductCatalog(driver);
    }

}
