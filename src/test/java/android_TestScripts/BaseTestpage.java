package android_TestScripts;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import android_Utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTestpage extends AppiumUtils{

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public Properties pr;

	
	@BeforeMethod(alwaysRun=true)
	public AndroidDriver AndroidAppiumSetup() throws URISyntaxException, IOException{
		//Automate appium server start
		
		FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
		pr = new Properties();
		pr.load(file);
		
		String IPaddress = pr.getProperty("Ipaddress");
		String port = pr.getProperty("port");

		
			service = appiumServerStart(IPaddress,Integer.parseInt(port));
			
		//UiAutomator2 options for android emulator capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(pr.getProperty("android_device"));
		options.setApp(pr.getProperty("android_app"));
		options.chromedriverUseSystemExecutable();
		
		//Appium Driver - Start
		driver  = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		

		return driver;
}
	
	//For capturing fails test cases screenshots in Extent Report
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	@AfterMethod(alwaysRun=true)
	public void AndroidAppiumTeardown() {
		
		driver.quit();
		service.stop();
		
	}
}
