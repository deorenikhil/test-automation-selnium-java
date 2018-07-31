package com.juniper.support.technologies.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	
	private By signInBtnXpath = By.xpath("//*[@id=\"Login\"]/div[4]/input");
										  
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public SignInPage clickSignInBtn() {
		System.out.println("clicking on sign in button");
		
		WebDriverWait wait = new WebDriverWait(driver, 105);
        wait.until(ExpectedConditions.presenceOfElementLocated(signInBtnXpath));
        
        System.out.println("after "+driver.getTitle());
		
		WebElement signInBtnElement = driver.findElement(signInBtnXpath);
		
		
		if(signInBtnElement.isDisplayed()||signInBtnElement.isEnabled())
			signInBtnElement.click();
		else System.out.println("Element not found");
		return new SignInPage(driver);
	}
	
	public void clickImagesLink() {
		//It should have a logic to click on images link
		//And it should navigate to google images page
	}
	
	public String getPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyBasePageTitle() {
		String expectedPageTitle="Google";
		return getPageTitle().contains(expectedPageTitle);
	}
}