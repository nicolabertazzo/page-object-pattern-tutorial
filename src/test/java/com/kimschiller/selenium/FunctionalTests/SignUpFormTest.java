package com.kimschiller.selenium.FunctionalTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SignUpFormTest extends FunctionalTest {

	@Test
	public void signUp() {

		SignUpPage signUpPage = new SignUpPage(driver).get();
		assertTrue(signUpPage.isInitialized());

		signUpPage.enterName("First", "Last");
		signUpPage.enterAddress("123 Street", "12345");

		ReceiptPage receiptPage = signUpPage.submit();

		assertEquals("Thank you!", receiptPage.getConfirmationHeader());
	}
}