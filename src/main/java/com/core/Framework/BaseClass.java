package com.core.Framework;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {
	  public static AppiumDriverLocalService service;
	  public static AppiumDriver<?>  driver;

public static String DevicePlatformName;
public static String UDID;
public static String AutomationName;
public static String AppPackage;
public static String AppActivity;
public static String UserName;
public static String Password;
public static String DeviceName;
public static String TvDetails;

@BeforeClass(alwaysRun=true)
		public void fileInputStrema() throws IOException {
	try {
			 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\core\\Framework\\global.properties");
				Properties prop=new Properties();
				prop.load(fis);
				
				 DevicePlatformName=prop.getProperty("DevicePlatformName");
				 AutomationName=prop.getProperty("AutomationName");
				 AppPackage=prop.getProperty("AppPackage");
				 AppActivity=prop.getProperty("AppActivity");
				 UserName=prop.getProperty("UserName");
				 Password=prop.getProperty("Password");
				 TvDetails=prop.getProperty("TVDetails");
				DeviceName=prop.getProperty("DeviceName");

	}catch (Exception e) {

		e.getMessage();
		throw e;
	}
		}
	  
	public AppiumDriverLocalService startServer()
	{
	boolean flag=	checkIfServerIsRunnning(4723);
	if(!flag)
	{	
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();

	}
	return service;
	}
	
	
	@AfterMethod(alwaysRun=true)
    	public void stopAppiumServer()
	{
	
		driver.quit();

	}
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static  AppiumDriver<?> capabilities() throws  MalformedURLException
	{
try {
		if(DevicePlatformName.equalsIgnoreCase("Android")) {
	     DesiredCapabilities capabilities = new DesiredCapabilities();
	     capabilities.setCapability("automationName", AutomationName);

	     capabilities.setCapability("deviceName", DeviceName);
	     capabilities.setCapability("newCommandTimeout", "10000");
	     capabilities.setCapability("appPackage", AppPackage);
	     capabilities.setCapability("appActivity", AppActivity);

    driver= new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	   	
		}
				}catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		} 
		return driver;
	}
	
	}
