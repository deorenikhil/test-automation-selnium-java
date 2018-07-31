package com.juniper.support.technologies.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

private WebDriver driver;

private By headerPageText = By.cssSelector(".hidden-small");
private By createAccountLink = By.id("link-signup");
private By emailTextBox = By.id("Email");
private By passwordTextBox = By.id("Passwd");
private By loginBtn = By.id("signIn");
private By errorMsgTxt = By.id("errormsg_0_Passwd");

private By userIdXpath = By.xpath("//*[@id=\"userid\"]");
private By passwordXpath = By.xpath("//*[@id=\"password\"]");
private By signInBtnXpath = By.xpath("//*[@id=\"Login\"]/div[4]/input");
private By SearcBarXpath = By.xpath("//*[@id=\"nxcsc-global-search-container\"]/input");
private By caseXpath = By.xpath("//*[@id=\"jnprDataTableContent_search_function_tab_cases\"]/div/div/div[2]/div/div[1]/div[3]/div/div/div[1]/div[2]/div/div[1]/div/div/div/div/span/a");
	public SignInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getSignInPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public boolean verifySignInPageTitle() {
		String expectedTitle = "Login : Juniper Networks";
		return getSignInPageTitle().contains(expectedTitle);
	}
	
	public boolean verifySignInPageText() {
		WebElement userId=driver.findElement(userIdXpath);
		WebElement password = driver.findElement(passwordXpath);
		WebElement login = driver.findElement(signInBtnXpath);
		//WebElement element = driver.findElement(headerPageText);
		//String pageText = element.getText();
	
		
		return true;
	}
	
		public boolean verifySignIn() {
			enterUserName("test");
			enterPassword("pass");
			clickOnSignIn();
			return getErrorMessage().contains("incorrect");
		}
		
		public void enterUserName(String userName) {
			WebElement emailTxtBox = driver.findElement(emailTextBox);
			if(emailTxtBox.isDisplayed())
				emailTxtBox.sendKeys(userName);
		}
		
		public void enterPassword(String password) {
			WebElement passwordTxtBox = driver.findElement(passwordTextBox);
			if(passwordTxtBox.isDisplayed())
				passwordTxtBox.sendKeys(password);
		}
		
		public void clickOnSignIn() {
			WebElement signInBtn = driver.findElement(loginBtn);
			if(signInBtn.isDisplayed())
				signInBtn.click();
		}
		
		public String getErrorMessage() {
			String strErrorMsg = null;
			WebElement errorMsg = driver.findElement(errorMsgTxt);
			if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
				strErrorMsg = errorMsg.getText();
			return strErrorMsg;
		}
		
		
}