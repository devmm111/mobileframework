package appium.mobileframework;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class capabilities {
	public static String appPackage,appActivity,Platformname,Devicename;
	public AppiumDriverLocalService service;
	public AppiumDriverLocalService startServer()
	{
		boolean flag = checkifserverisRunning(4723);
		if(!flag)
		{
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\user\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723));
		service.start();
		
	}
		return service;
	}
	
	public static boolean checkifserverisRunning(int port)
	{
		boolean isServerRunning=false;
		ServerSocket serversocket;
		try{
			serversocket = new ServerSocket(port);
			serversocket.close();
		}
		catch(IOException e)
		{
			isServerRunning = true;
		}
		finally {
			serversocket=null;
		}
		return isServerRunning;
	}

	/*public static void startEmulator() throws IOException
	{
		Runtime.getRuntime().exec(System.getProperty(Devicename));
	}*/

	public static AndroidDriver<AndroidElement> capability() throws IOException 
	{
		FileReader fis = new FileReader("C:\\Users\\user\\eclipse-workspace\\MobileFramework\\src\\main\\java\\Global.properties");
		Properties pro = new Properties();
		pro.load(fis);
		appPackage = pro.getProperty("appPackage");
		appActivity = pro.getProperty("appActivity");
		Platformname = pro.getProperty("platformname");
		Devicename = pro.getProperty("devicename");
		
		/*if(Devicename.contains("myphone"))
		{
			startEmulator();
		}*/
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, Devicename);
		//mandatory
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platformname);
		//mandatory
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"C:\\Users\\user\\OneDrive\\Desktop\\Selenium\\chromedriver.exe");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,  appPackage);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(cap);
		//AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	}
	

}

