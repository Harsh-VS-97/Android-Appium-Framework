package android_Utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	
	public AppiumDriverLocalService service;
	public Properties p;
	
	public AppiumDriverLocalService appiumServerStart(String IPaddress, int port) throws IOException {
		
		FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);
		
		service = new AppiumServiceBuilder().withAppiumJS(new File(p.getProperty("appiumserverServiceFile")))
				.withIPAddress(IPaddress).usingPort(port).build();
		
		service.start();
		
		return service;
				
	}

}
