package pageObjects_Android;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePageObj {

	public AndroidDriver driver;
	
	public BasePageObj(AndroidDriver driver){
		
		this.driver = driver;
		
		/*
		 * For Android: use AppiumFieldDecorator class with driver for pagefactory.
		 * if not it will give invalidElementSelector exception for css slelector when finding 
		 * webelements in android
		 */
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
}
