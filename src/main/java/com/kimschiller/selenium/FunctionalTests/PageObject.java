package com.kimschiller.selenium.FunctionalTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

/**
 * https://github.com/SeleniumHQ/selenium/wiki/LoadableComponent
 * https://github.com/SeleniumHQ/selenium/wiki/PageObjects
 * 
 * @author Nicola Bertazzo
 */

public abstract class PageObject <T extends LoadableComponent<T>> extends LoadableComponent<T> {

		private WebDriver driver;

		public PageObject(WebDriver driver) {
			this.driver = driver;
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			PageFactory.initElements(driver, this);
		}

		public WebDriver getDriver() {
			return driver;
		}
}
