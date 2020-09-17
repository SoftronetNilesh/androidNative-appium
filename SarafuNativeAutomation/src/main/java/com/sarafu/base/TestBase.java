package com.sarafu.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {

	public static AndroidDriver<MobileElement> driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;

	public TestBase() {

		prop = new Properties();

		File file = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\sarafu\\configuration\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	


	public static void initialisation() throws MalformedURLException {

		File appDir = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\sarafu\\application\\Sarafu_Test.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("no",true);
        
        capabilities.setCapability("newCommandTimeout", 100000);
         
        // Name of the OS: Android, iOS or FirefoxOS
        capabilities.setCapability("platformName", "Android");
        
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

         
        //set the name of the connected device.you have to give same name in both server and the code
        
        capabilities.setCapability("deviceName","Nilesh API 29");
         
        //Mobile OS version. My device is running Android 10.0
        capabilities.setCapability("version","10.0");
        
        capabilities.setCapability("app", appDir.getAbsolutePath());

        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
        
        wait =new WebDriverWait(driver, 25);
        
        js = (JavascriptExecutor) driver;
		
	}
}
