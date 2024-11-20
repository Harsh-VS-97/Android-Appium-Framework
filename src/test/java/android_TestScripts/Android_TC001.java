package android_TestScripts;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects_Android.FormPage;

public class Android_TC001 extends BaseTestpage{
	
	public Properties conf;
	
	@Test(priority = 1)
	public void FormPageTest() throws InterruptedException {
		
		FormPage fp = new FormPage(driver);
		fp.EnterName(pr.getProperty("default_user"));
		fp.Selectgender(pr.getProperty("default_gender"));
		fp.SelectCountryFromDropDown(pr.getProperty("default_country"));
		fp.ClickLetsShop();
		Thread.sleep(2000);
	
	}
	
	@Test(priority = 2)
	public void FormPageToastMessageTest() throws InterruptedException {
		
		FormPage fp = new FormPage(driver);
		fp.Selectgender(pr.getProperty("default_gender"));
		fp.SelectCountryFromDropDown(pr.getProperty("default_country"));
		fp.ClickLetsShop();
		Thread.sleep(2000);
		String ActualMessage = fp.ToastMsg();
		
		Assert.assertEquals("Please enter your name", ActualMessage);
	}
	
}
