package com.juniper.support.technologies.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.juniper.support.technologies.pages.BasePage;
import com.juniper.support.technologies.pages.SignInPage;
import com.juniper.support.technologies.utility.BaseSetup;

public class DashboardTest extends BaseSetup {
	private WebDriver driver;
	private SignInPage signInPage;
	private BasePage basePage;
	
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test
	public void verifySignInFunction() {
		System.out.println("Sign In functionality details...");
		basePage = new BasePage(driver);
		System.out.println(driver.getTitle());
//		
//		signInPage = basePage.clickSignInBtn();
//		Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn't match");
//		Assert.assertTrue(signInPage.verifySignInPageText(), "Page text not matching");
//		//Assert.assertTrue(signInPage.verifySignIn(), "Unable to sign in");

	}
	
}
