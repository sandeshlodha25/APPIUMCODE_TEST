package com.synechron.javaappiumtestcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.*;
import org.testng.annotations.*;

public class AndroidCalciTest {

	WebDriver driver;

	
	@BeforeTest
	public void setUp() throws MalformedURLException{

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("deviceName", "SandySamsung");

		dc.setCapability(CapabilityType.BROWSER_NAME, "Android");

		dc.setCapability(CapabilityType.PLATFORM,"Android");

		dc.setCapability("platformName","Android");

		dc.setCapability(CapabilityType.VERSION,"6.0.0");

		dc.setCapability("appPackage", "com.sec.android.app.popupcalculator");

		dc.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4729/wd/hub"),dc);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=0)
	public void testSum() {
//		driver.findElements(By.className("//android.widget.button")).click();
		
		driver.findElement(By.name("2")).click();
		
		driver.findElement(By.name("+")).click();
		
		driver.findElement(By.name("2")).click();
		
		driver.findElement(By.name("=")).click();
		
		String res = driver.findElement(By.className("android.widget.EditText")).getText();
		
		System.out.println("Result Sum is "+res);
		
	}
	
	
	@Test(priority=1)
	public void testSub() {
//		driver.findElements(By.className("//android.widget.button")).click();
		
		driver.findElement(By.name("9")).click();
		
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_sub")).click();
//		driver.findElement(By.name("−")).click();
		
		driver.findElement(By.name("7")).click();
		
		driver.findElement(By.name("=")).click();
		
		String res = driver.findElement(By.className("android.widget.EditText")).getText();
		
		System.out.println("Result Sub is "+res);
		
	}
	
	@Test(priority=2)
	public void testMultiply() {
//		driver.findElements(By.className("//android.widget.button")).click();
		
		driver.findElement(By.name("9")).click();
		
		driver.findElement(By.name("×")).click();
		
		driver.findElement(By.name("2")).click();
		
		driver.findElement(By.name("=")).click();
		
		String res = driver.findElement(By.className("android.widget.EditText")).getText();
		
		System.out.println("Result Multiply is "+res);
		
	}
	
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

}
