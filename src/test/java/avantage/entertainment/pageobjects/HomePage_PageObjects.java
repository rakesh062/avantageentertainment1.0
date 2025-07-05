package avantage.entertainment.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage_PageObjects extends BasePage {

	public HomePage_PageObjects(WebDriver driver) {
		
		super(driver);
	
	}
	
	//Author:Rakesh_Ravikumar  CreationDate:12-June-2025  ModifiedDate: 17-June-2025
	
	//Locators of the Home page 
	
	@FindBy(xpath="(//span[contains(text(),'Help')])[1]//parent::button//preceding-sibling::button")
	private static WebElement hamburgerMenuSelectionButton; //WebElement to locate hamburger menu button in the header of the Home Page
	
	@FindBy(xpath="(//span[contains(text(),'Help')])[1]//parent::button//preceding-sibling::div")
	WebElement languageSelectionIcon; //WebElement to locate language selection icon in the header of the Home Page
	
	@FindBy(xpath="(//span[contains(text(),'Help')])[1]")
	WebElement helpButtonIcon; //WebElement to locate help button in the header of the Home Page
	
	@FindBy(xpath="//img[@src='/assets/a44530182dbf15483f77.svg']")
	WebElement avantagelogoimage; //WebElement to locate avantage logo image in the header of the Home Page
	
	@FindBy(xpath="//span[contains(text(),'My Contests')]")
	WebElement myContestsButtonIcon; //WebElement to locate My Contests button in the header of the Home Page
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	WebElement loginButtonInTheHeader; //WebElement to locate Login button in the header of the Home Page
	
	@FindBy(xpath="//span[contains(text(),'Join')]")
	WebElement joinButtonIcon; //WebElement to locate Join button in the header of the Home Page
	
	@FindBy(xpath="//p[text()='Multi-level tournaments']//following-sibling::a")
	WebElement multiLevelContests_worldChampionShip; //WebElement to locate World Championship link under multilevel contests 
															//of Menu
	
	//******************** Date: 17-June-2025 Author: Rakesh Ravikumar *****************************************************************
	
	@FindBy(xpath="//h1[contains(text(),'Create an account')]")
	WebElement registerModalMessage1; //WebElement to locate Registration modal message 1
	  
	@FindBy(xpath="//button[@data-testid='authWithEmailBtn']")
	WebElement emailRegistrationButton; //webElement to locate register withemail button
	
	@FindBy(xpath="//p[text()='Email']//parent::div//following-sibling::div[1]")
	WebElement emaiIdInputBoxRegistration; //webElement to locate email id input box in the registration modal
	
	@FindBy(xpath="//p[text()='Choose Password']//parent::div//following-sibling::div[1]")
	WebElement choosePasswordInputBoxregistration; //webElement to locate choose password input box in the registration modal
	
	@FindBy(xpath="//p[text()='Confirm Password']//parent::div//following-sibling::div[1]")
	WebElement confirmPasswordInputRegistration; //webElement to locate choose password input box in the registration modal
	
	@FindBy(xpath="//button[@data-testid='authWithEmailBtn']")
	WebElement emailLoginButton; //webElement to locate login with email button
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emaiIdInputBoxLogin; //webElement to locate email id input box in the Login modal
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordInputBoxLogin; //webElement to locate password input box in the Login modal
	
	@FindBy(xpath="//span[text()='Log In']")
	WebElement loginButtonToLogin; //webElement to locate choose password input box in the registration modal
	
	//******************** Date: 18-June-2025 Author: Rakesh Ravikumar *****************************************************************
	
	@FindBy(xpath="//span[text()='My Account']") //WebElement to locate My Account button displayed in the menu after login
	WebElement myAccountButtonInMenu;
	
	@FindBy(xpath="//p[text()='Log Out']")
	WebElement logoutButtonPlayerAccount; //WebElement to locate Log Out button in thge My Account modal after login
	
	@FindBy(xpath="//p[text()='Invalid email or password.']")
	WebElement invalidLoginErrorMessage; //WebElement to locate Error message displayed when user login with invalid credentials
	
	//Action Methods on the locators of the Home Page
	
	//return true or false based on visibility of the hamburger menu icon
	public boolean hamburgerMenuIconVisible() {
		if(wait.until(ExpectedConditions.visibilityOf(hamburgerMenuSelectionButton)).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//return true or false based on visibility of the language selection icon
	public boolean languageSelectionIconVisible() {
		if(wait.until(ExpectedConditions.visibilityOf(languageSelectionIcon)).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//return true or false based on visibility of the help button
	public boolean helpbuttonIconVisible() {
		if(wait.until(ExpectedConditions.visibilityOf(helpButtonIcon)).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//return true or false based on visibility of the avantage logo image
	public boolean avantageLogoImageVisible() {
		if(wait.until(ExpectedConditions.visibilityOf(avantagelogoimage)).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//return true or false based on visibility of the My Contests icon
	public boolean myContestsIconVisible() {
		if(wait.until(ExpectedConditions.visibilityOf(myContestsButtonIcon)).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//return true or false based on visibility of the Login icon
	public boolean loginbuttonIconVisible() {
		if(wait.until(ExpectedConditions.visibilityOf(loginButtonInTheHeader)).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//return true or false based on visibility of the Join button
	public boolean joinbuttonIconVisible() {
		if(wait.until(ExpectedConditions.visibilityOf(joinButtonIcon)).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
		
		
		
	}
	
	
	//Action method to click on hamburger menu icon
	public void clickOnHamburgerMenuSelectionButton() {
	
		wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenuSelectionButton)).click();
		
		
	}
	
	//Action method to click on Language selection icon
	public void clickOnLanguageSelectionIcon() {
		
		wait.until(ExpectedConditions.elementToBeClickable(languageSelectionIcon)).click();
		
		
	}

	//Action method to click on help button icon
	public void clickOnHelpButtonIcon() {
		
		wait.until(ExpectedConditions.elementToBeClickable(helpButtonIcon)).click();
		
		
		
	}
	
	
	//Date - 17-June-2025
	//Action method to click on Login button in the header menu
	public void clickOnLoginButtonInTheHeader() {
		
		wait.until(ExpectedConditions.elementToBeClickable(loginButtonInTheHeader)).click();
		
		
		
	}
	
	//Action method to click on Login with Email button in the login modal
	public void clickOnLoginWithEmailInLoginModal() {
		
		wait.until(ExpectedConditions.elementToBeClickable(emailLoginButton)).click();

		
	}
	
	public void enterEmailIdtoLogin(String emailIdForLogin) {
		
		wait.until(ExpectedConditions.elementToBeClickable(emaiIdInputBoxLogin)).click();
		emaiIdInputBoxLogin.clear();
		emaiIdInputBoxLogin.sendKeys(emailIdForLogin);
		
	}
	
	//Action method to enter password in password input box for login
	public void enterPasswordtoLogin(String passwordForLogin) {
		
		wait.until(ExpectedConditions.elementToBeClickable(passwordInputBoxLogin)).click();
		passwordInputBoxLogin.clear();
		passwordInputBoxLogin.sendKeys(passwordForLogin);
		
	}
	
	//Action method to click on Log In button for login
	public void clickOnLogInButtonforLogin() {
		
		wait.until(ExpectedConditions.elementToBeClickable(loginButtonToLogin)).click();
		
	}
	
	//Date 18-June-2025 Author: Rakesh Ravikumar
	
	//return true or false based on visibility of the My Account Button in menu
	public boolean myAccountButtonInMenuVisible() {
		if(wait.until(ExpectedConditions.visibilityOf(myAccountButtonInMenu)).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//Action methot to click on My Account button from Menu
	public void clickOnmyAccountButtonInMenu() {
		
		wait.until(ExpectedConditions.elementToBeClickable(myAccountButtonInMenu)).click();
		
	}
	
	//Action method to click on Log Out button in the Player account modal
	public void clickOnLogOutButtonInPlayerAccountModal() {
		
		wait.until(ExpectedConditions.elementToBeClickable(logoutButtonPlayerAccount)).click();
		
	}
	
	//return true or false based on visibility of error message displayed when logged in with invalid credential
	public boolean errorMeesageDisplayeWhenLoggedInWithInvalidCredential() {
		if(wait.until(ExpectedConditions.visibilityOf(invalidLoginErrorMessage)).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	
	
	
	

	

}
