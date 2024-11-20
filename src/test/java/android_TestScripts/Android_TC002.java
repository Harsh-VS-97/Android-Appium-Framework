package android_TestScripts;

import org.testng.annotations.Test;

import pageObjects_Android.FormPage;
import pageObjects_Android.ProdListPage;

public class Android_TC002 extends BaseTestpage{
	
	@Test
	
	public void ProdCatalogTest() throws InterruptedException{
		
	FormPage fp = new FormPage(driver);
	fp.EnterName(pr.getProperty("default_user"));
	fp.Selectgender(pr.getProperty("default_gender"));
	fp.SelectCountryFromDropDown(pr.getProperty("default_country"));
	fp.ClickLetsShop();
	
	ProdListPage pr = new ProdListPage(driver);
	pr.selectProduct("Jordan Lift Off");
	pr.selectProduct("Air Jordan 4 Retro");
	pr.clickCart();
	Thread.sleep(2000);
	
	}
}
