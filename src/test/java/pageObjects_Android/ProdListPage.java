package pageObjects_Android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import android_GestureActions.Android_Actions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProdListPage extends BasePageObj{

	public ProdListPage(AndroidDriver driver) {
		super(driver);
	
	}
	Android_Actions a = new Android_Actions(driver);
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")
	private List<WebElement> prodview;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement CartBtn;
	
	public void selectProduct(String ProdName) {
		
		a.ScrollToText(ProdName);
		for(WebElement prod : prodview) {
			String pname = prod.getText();
			if(pname.equalsIgnoreCase(ProdName)) {
				WebElement product = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='" + pname + "']//.."));
				WebElement AddToCart = product.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']"));
				AddToCart.click();
			}
		}
		}
			
	public void clickCart() throws InterruptedException {
		
		CartBtn.click();
		Thread.sleep(2000);
	}
}
