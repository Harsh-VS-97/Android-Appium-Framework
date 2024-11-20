package pageObjects_Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import android_GestureActions.Android_Actions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormPage extends BasePageObj{

	public FormPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
		
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleRadio;
		
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleRadio;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryDropDown;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopBtn;
	
	@AndroidFindBy(xpath="//android.widget.Toast[1]")
	private WebElement toastMsg;
	
	public void EnterName(String Name) {
		
		nameField.sendKeys(Name);
		driver.hideKeyboard();
	}
	
	public void Selectgender(String Gender) {
		if(Gender.equalsIgnoreCase("Male")) {
			maleRadio.click();
		}
		else if(Gender.equalsIgnoreCase("Female")) {
			femaleRadio.click();
		}
		else {
			
			System.out.println("***** INVALID GENDER *******");
		}
	}
		
	
	public void SelectCountryFromDropDown(String Country) {
		
		countryDropDown.click();
		Android_Actions a = new Android_Actions(driver); //creating instance to android actions class
		a.ScrollToText(Country);
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id= 'android:id/text1' and @text= '"+ Country +"']")).click();
	}
	
	public void ClickLetsShop() {
		
		letsShopBtn.click();
	}
	
	public String ToastMsg() {
		
		String Message = toastMsg.getAttribute("name");
		
		return Message;
	}

}
