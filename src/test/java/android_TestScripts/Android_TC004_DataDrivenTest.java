package android_TestScripts;

import org.testng.annotations.Test;

import android_Utils.FormDataProvider;
import pageObjects_Android.FormPage;

public class Android_TC004_DataDrivenTest extends BaseTestpage{

	@Test(dataProvider="FormDataProvider", dataProviderClass=FormDataProvider.class)
	public void FormDataDrivenTest(String username,String gender, String country) throws InterruptedException {
		
		FormPage formPage = new FormPage(driver);
		formPage.EnterName(username);
		Thread.sleep(1000);
		formPage.Selectgender(gender);
		Thread.sleep(1000);
		formPage.SelectCountryFromDropDown(country);
		Thread.sleep(1000);
		formPage.ClickLetsShop();
		Thread.sleep(2000);
		
	}
}
