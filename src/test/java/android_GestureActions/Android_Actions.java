package android_GestureActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Android_Actions {

	public AndroidDriver driver;
			
	public Android_Actions(AndroidDriver driver){
		
		this.driver = driver;
	}
	//Long Press Action
	public void LongPressAction(WebElement ele) {
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			"Duration",2000)); //double click gesture
	}
	
	//Scrolling till Last Action
	public void ScrollTillEnd() {
		
		boolean canScrollMore;
		do {
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 1.0
			));
		}
		while(canScrollMore); //will scroll till last
	}
	
	public void ScrollTillTop() {
		
		boolean canScrollMore;
		do {
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "up",
			    "percent", 1.0
			));
		}
		while(canScrollMore); //will scroll till last
	}
	
	
	//Scroll till Element found Action
	public void ScrollToText(String eleName) {
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + eleName + "\"))"));
	}
	
	//Swipe Action
	public void SwipeAction(WebElement e, String Direction) {
		
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement) e).getId(),
			    "direction", Direction
			));
	}
	
}
