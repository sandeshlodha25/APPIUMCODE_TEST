package com.synechron.javaappiumtestcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class SampleAVDTest {

	WebDriver driver = null;

	// Code for web applications
	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.APP, "C:\\ProgFiles\\apk\\ammx-release-2018.02.26.981.apk");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.0");
		dc.setCapability(MobileCapabilityType.PLATFORM, "Android");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
		
//		dc.setCapability("avd", "AVD_Nexus_5_442");
//		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");

		
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.money.manager.ex");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.money.manager.ex.home.MainActivity");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4729/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	
}
