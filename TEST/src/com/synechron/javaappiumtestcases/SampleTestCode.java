package com.synechron.javaappiumtestcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

// Code for native applications
public class SampleTestCode {

	WebDriver driver = null;

	// Code for web applications
	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability("platformName", "Android");
		dc.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		dc.setCapability(CapabilityType.PLATFORM, "Android");
		dc.setCapability(CapabilityType.VERSION, "6.0.0");
		dc.setCapability("deviceName", "SandySamsung");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4729/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void launch() throws InterruptedException {
		// driver.findElement(By.id("com.android.chrome:id/url_bar")).sendKeys("www.google.com");
		driver.get("http://www.google.com");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		/*wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lst-ib")));
		WebElement keyword = driver.findElement(By.name("lst-ib"));
		keyword.sendKeys("appium");
		driver.findElement(By.id("btnK")).click();
		Thread.sleep(5000);*/
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}
