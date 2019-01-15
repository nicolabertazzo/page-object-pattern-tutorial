package com.kimschiller.selenium.FunctionalTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends PageObject<SignUpPage> {

	private static final String SIGN_UP_PAGE_URL = "http://www.kimschiller.com/page-object-pattern-tutorial/index.html";

	@FindBy(id = "firstname")
	private WebElement firstName;

	@FindBy(id = "lastname")
	private WebElement lastName;

	@FindBy(id = "address")
	private WebElement address;

	@FindBy(id = "zipcode")
	private WebElement zipCode;

	@FindBy(id = "signup")
	private WebElement submitButton;

	public SignUpPage(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return firstName.isDisplayed();
	}

	public void enterName(String firstName, String lastName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);

		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}

	public void enterAddress(String address, String zipCode) {
		this.address.clear();
		this.address.sendKeys(address);

		this.zipCode.clear();
		this.zipCode.sendKeys(zipCode);
	}

	public ReceiptPage submit() {
		submitButton.click();
		return new ReceiptPage(getDriver()).get();
	}

	@Override
	protected void isLoaded() throws Error {
		if (!getDriver().getTitle().startsWith("Sign up")) {
			throw new Error("Sign Up Page not loaded!");
		}
	}

	@Override
	protected void load() {
		getDriver().get(SIGN_UP_PAGE_URL);
	}
}
