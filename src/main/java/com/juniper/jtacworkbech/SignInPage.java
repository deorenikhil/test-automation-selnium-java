package com.juniper.jtacworkbech;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
private By SearcBarXpath = By.xpath("//*[@id=\"additionalSearch0\"]");
private By caseXpath = By.xpath("//*[@id=\"caseNumber\"]/span");
private By editNoteXpath = By.xpath("//*[@id=\"2017-1128-0462S001005056A318531ED7B58A407062DD31FC\"]/div[1]/div");
									
private By editIcon = By.xpath("//*[@id=\"2017-1128-0462S001005056A318531ED7B58A407062DD31FC\"]/div[2]/div/a[1]/i");
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
		userId.sendKeys("jss.jnpr@gmail.com");
		password.sendKeys("jss123");
		login.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 105);
        wait.until(ExpectedConditions.titleContains("Dashboard | JTACWB"));
        
		String pageTitle = driver.getTitle();
		
		String expectedPageText = "Dashboard | JTACWB";
		
		 wait = new WebDriverWait(driver, 105);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(SearcBarXpath));
			
			WebElement searchBar = driver.findElement(SearcBarXpath);

			searchBar.sendKeys("2017-1128-0462");
			
			searchBar.sendKeys(Keys.ENTER);
			
			wait = new WebDriverWait(driver, 105);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(caseXpath));
			
			WebElement caseId = driver.findElement(caseXpath);
			caseId.click();
        
			
			System.out.println("After clicking case");
			
			wait = new WebDriverWait(driver, 105);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(editNoteXpath));
			
			WebElement editNote = driver.findElement(editNoteXpath);
			
			editNote.click();
			
			System.out.println("After clicking edit case");
			
			wait = new WebDriverWait(driver, 105);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(editIcon));
			
			
			WebElement editLink = driver.findElement(editIcon);
			
			editLink.click();
		 
		
		return pageTitle.contains(expectedPageText);
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