package pageObjects_Android;

import java.util.List;

import org.openqa.selenium.WebElement;

import android_GestureActions.Android_Actions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartPage extends BasePageObj{

	public CartPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	Android_Actions a = new Android_Actions(driver);
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement Title;

	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	private List<WebElement> productName;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> price;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement ActualPrice;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement TandCBtn;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement CloseBtn;
	
	@AndroidFindBy(xpath="//android.widget.CheckBox")
	private WebElement Notify_Checkbox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement visitToWebsiteBtn;
	
	public String CheckTitlePage() {
		
		String TitleName = Title.getText();
		
		return TitleName;
	}
	
	public void printSelectedProduct() {

		for(WebElement prod: productName) {
			
			System.out.println(prod.getText());
		}
		
	}
	
	public double sumPrice() {
		 	double totprice=0;
			for(WebElement pr: price) {
			
			String amount = pr.getText().substring(1);
			
			totprice = totprice + Double.parseDouble(amount);
		}
		return totprice;
		
	}
	
	public double actualPrice() {
		
		String actAmount = ActualPrice.getText().substring(1);
		
		return Double.parseDouble(actAmount);
	}
	
	public void clickTermandCondition() throws InterruptedException {
		
		a.LongPressAction(TandCBtn);
		Thread.sleep(1000);
		CloseBtn.click();
		
	}
	
	public void ClickNotifyCheckBox() {
		
		Notify_Checkbox.click();
	}
	
	public void clickToWebsiteBtn() {
		
		visitToWebsiteBtn.click();
	}
}
