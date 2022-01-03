package appium.mobileframework;

import org.testng.annotations.Test;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Driver;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
public class demo1 extends capabilities{
	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void BT() throws IOException {
		//driver = capability();
		//System.out.println("Hello guys..!!");
	}
	@Test(enabled =false)
	public void testcase1() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//select region
		WebElement expandlist = driver.findElement(By.id("android:id/text1"));
		expandlist.click();
		WebElement wb =driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))");
		//Thread.sleep(2000);
		wb.click();
		//Thread.sleep(1000);
		//Select the name
		WebElement name = driver.findElementById("com.androidsample.generalstore:id/nameField");
		name.sendKeys("Dev");
		//select gender
		//driver.findElement(By.xpath("//*[@text='Female']")).click();
		//click on let's shop
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		WebElement wish = driver.findElement(By.id("com.androidsample.generalstore:id/rvProductList"));
		//scroll to LeBron Soldier 12 shoes
		((FindsByAndroidUIAutomator<MobileElement>) wish).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"LeBron Soldier 12\"))");
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"LeBron Soldier 12\")");
		Thread.sleep(2000);
	}
	@Test(enabled =false)
	public void testcase2() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//select region
		WebElement expandlist = driver.findElement(By.id("android:id/text1"));
		expandlist.click();
		//click on let's shop
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		Thread.sleep(1000);
		String errmsg = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(errmsg);
	}
	@Test(enabled =false)
	public void testcase3() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Select the name
		
		WebElement name = driver.findElementById("com.androidsample.generalstore:id/nameField");
		name.sendKeys("Dev");
		/*WebElement wb =driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))");
		Thread.sleep(2000);
		wb.click();*/
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))");		
		//driver.findElement(By.xpath("//*[@text='ADD TO CART']")).click();
		//driver.findElement(By.xpath("//*[@text='ADD TO CART']")).click();
		Thread.sleep(2000);
		//driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		//driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
		
		//i want to find the size of the product or find how many products are there
		//System.out.println("Size of Product List is " +driver.findElements(By.id("com.androidsample.generalstore:id/rvProductList")).size());
		
		//i want to scroll to an element//to make the element in the instance of 0//i want to scroll based on the product list
		//Scroll to a particular item
		//the below 2 works also
		//driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/productName\")).scrollIntoView(new UiSelector().text(\"Converse All Star\"));");
		//driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/productName\")).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"));");
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().text(\"Jordan Lift Off\"))");
		//what if i want to click on the specific element add to cart Jordan 6 rings
		
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.equalsIgnoreCase("Jordan Lift Off"))
			{
				System.out.println(productName);
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
		System.out.println("clicked on jordan 6 rings");
	
	}
	@Test
	public void testcase4() throws InterruptedException, IOException {
		
		service = startServer();
		driver = capability();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//I want to enter the name
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Sahana");
		driver.findElementByXPath("//*[@text='Female']").click();

		//I want to scroll but I have to click on the menu button
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();

		//I want to click on let's shop
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();

		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		Thread.sleep(3000);
		//This is for forst value
		String amount1 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText();
		//I have to remove the dollar sign
		amount1 = amount1.substring(1);
		Double amountvalue = Double.parseDouble(amount1);
		//System.out.println(amount1);

		//This is for second value
		String amount2 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();
		amount2 = amount2.substring(1);
		Double amount2value = Double.parseDouble(amount2);
		//System.out.println();
		//System.out.println(amount2);

		//I want to add amountvalue with amount2value
		Double Totalamount = amountvalue + amount2value;

		//I should do it for the final value
		String Total = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		Total = Total.substring(1);
		Double Totalvalue = Double.parseDouble(Total);

		//Asert to check if the value is added 
		Assert.assertEquals(Totalvalue, Totalamount);
		System.out.println("The amount is equal");

		WebElement tap = driver.findElementByXPath("//*[@text='Send me e-mails on discounts related to selected products in future']");

		Thread.sleep(3000);

		TouchAction ta = new TouchAction(driver);
		ta.tap(tapOptions().withElement(element(tap))).perform();
		WebElement LP = driver.findElementByAndroidUIAutomator("text(\"Please read our terms of conditions\")");
		ta.longPress(longPressOptions().withElement(element(LP)).withDuration(ofSeconds(2))).release().perform();

		driver.findElementById("android:id/button1").click();
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		Thread.sleep(9000);
		System.out.println("The WebPage is open");

		//What happens when I visit to WebPage
		//So how do I know whether I am in native app or webapp

		//This can be used when you have a multiple mobile view
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}

		//This will take me from native app to hybrid app
	    driver.context("WEBVIEW_com.androidsample.generalstore");


	    driver.findElement(By.xpath("//*[@name='q']")).sendKeys("moolya");
    	driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
    	Thread.sleep(5000);

    	//This will take me back to native app
    	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.context("NATIVE_APP");
	    service.stop();

				
	}
}

