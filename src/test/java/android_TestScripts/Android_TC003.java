package android_TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects_Android.CartPage;
import pageObjects_Android.FormPage;
import pageObjects_Android.ProdListPage;

public class Android_TC003 extends BaseTestpage{
	
	public double totAmount=0;
	public double expAmount=0;
	
	@Test
	public void CartTest() throws InterruptedException {
		
		FormPage fp = new FormPage(driver);
		fp.EnterName(pr.getProperty("default_user"));
		fp.Selectgender(pr.getProperty("default_gender"));
		fp.SelectCountryFromDropDown(pr.getProperty("default_country"));
		fp.ClickLetsShop();
		
		ProdListPage pr = new ProdListPage(driver);
		pr.selectProduct("Jordan Lift Off");
		pr.selectProduct("Air Jordan 4 Retro");
		pr.clickCart();
		
		CartPage cp = new CartPage(driver);
		String pageTitle = cp.CheckTitlePage();
		if(pageTitle.equalsIgnoreCase("Cart")) {
			
			cp.printSelectedProduct();
			totAmount = cp.sumPrice();
			expAmount = cp.actualPrice();
			System.out.println(totAmount);
			System.out.println(expAmount);
			Assert.assertEquals(totAmount, expAmount);
			
			cp.ClickNotifyCheckBox();
			Thread.sleep(2000);
			cp.clickTermandCondition();
			cp.clickToWebsiteBtn();
			Thread.sleep(5000);
		}
	}
}
