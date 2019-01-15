package com.kimschiller.selenium.FunctionalTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * https://github.com/SeleniumHQ/docker-selenium
 * https://github.com/SeleniumHQ/selenium/wiki/RemoteWebDriver
 * 
 * docker network create grid
 * docker run -d -p 4444:4444 --net grid --name selenium-hub selenium/hub:3.141.59-dubnium
 * docker run -d --net grid -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-chrome:3.141.59-dubnium
 * docker run -d --net grid -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-firefox:3.141.59-dubnium
 * 
 * @author Nicola Bertazzo
 */
public class FunctionalTestRemoteDriver {

	protected static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws MalformedURLException{
		String nodeUrl = "http://localhost:4444/wd/hub";
		driver = new RemoteWebDriver(new URL(nodeUrl), new ChromeOptions());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void cleanUp(){
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public static void tearDown(){
		driver.close();
	}	
}
