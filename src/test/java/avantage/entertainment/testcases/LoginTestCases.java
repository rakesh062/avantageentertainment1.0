package avantage.entertainment.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import avantage.entertainment.pageobjects.HomePage_PageObjects;
import avantage.entertainment.utilities.DataProviderClass;
import avantage.entertainment.utilities.DriverManager;

public class LoginTestCases extends BaseClass {
	
	//Test case to validate login successful with valid user credentials
	@Test(groups="smoke")
	public void loginWithEmailValidUsers() {
		System.out.println("Running on thread: " + Thread.currentThread().getName());
		
		WebDriver driver = DriverManager.getDriver();
        driver.get("https://play.avantagegames.com/av-baccarat");
        driver.manage().window().maximize();
        waitToLoadPage(driver);


		 HomePage_PageObjects hmpgObj=new HomePage_PageObjects(driver);
		
		logMethodStart(logger);
		 
		try {
			
			System.out.println("Running on thread: " + Thread.currentThread().getName());
			
		hmpgObj.clickOnLoginButtonInTheHeader();
		logger.info("Clicked on Login button in the header");
		
		hmpgObj.clickOnLoginWithEmailInLoginModal();
		logger.info("Clicked on Login with email image button in the login modal");
		
		
		hmpgObj.enterEmailIdtoLogin(propertiesReader.getProperty("emailId"));
		logger.info("entered email id in the login modal");
		
		hmpgObj.enterPasswordtoLogin(propertiesReader.getProperty("password"));
		logger.info("entered pasword in the login modal");
		
		hmpgObj.clickOnLogInButtonforLogin();
		logger.info("Clicked on Log In button in the login modal");
		Thread.sleep(3000);
		
		hmpgObj.clickOnHamburgerMenuSelectionButton();
		logger.info("Clicked on Log hamburger menu in the header");
		
		
		Assert.assertEquals(hmpgObj.myAccountButtonInMenuVisible(), true, "My Account Button is not visible in the Menu");
		logger.info("My Account button displayed after successful login");;
		
		hmpgObj.clickOnmyAccountButtonInMenu();
		logger.info("Click on My Account button in the menu");
		
		
		hmpgObj.clickOnLogOutButtonInPlayerAccountModal();
		logger.info("Click on logout from Player account modal");
		
		
		}catch (Exception e) {
		    Assert.fail(e.getMessage());
		}

		logMethodend(logger);
		
	}
	
	


	//Test case to validate login with valid and invalid user credentials
		@Test(dataProvider="loginData", dataProviderClass=DataProviderClass.class, groups="regression")
		public void loginWithEmailValidInvalidUsers(String userEmail, String userPassword, String validInvalidCredential) {
			
			WebDriver driver = DriverManager.getDriver();
	        driver.get("https://play.avantagegames.com/av-baccarat");
	        driver.manage().window().maximize();
			 HomePage_PageObjects hmpgObj=new HomePage_PageObjects(driver);
			
			 logMethodStart(logger);
			 
			try {
			hmpgObj.clickOnLoginButtonInTheHeader();
			logger.info("Clicked on Login button in the header");
			
			hmpgObj.clickOnLoginWithEmailInLoginModal();
			logger.info("Clicked on Login with eamil image button in the login modal");
			
			hmpgObj.enterEmailIdtoLogin(userEmail);
			logger.info("entered email id in the login modal");
			
			hmpgObj.enterPasswordtoLogin(userPassword);
			logger.info("entered pasword in the login modal");
			
			hmpgObj.clickOnLogInButtonforLogin();
			logger.info("Clicked on Log In button in the login modal");
			Thread.sleep(3000);
			
			if(validInvalidCredential.equalsIgnoreCase("valid")) {
				
				hmpgObj.clickOnHamburgerMenuSelectionButton();
				logger.info("Clicked on Log hamburger menu in the header");
				
				Assert.assertEquals(hmpgObj.myAccountButtonInMenuVisible(), true, "My Account Button is not visible in the Menu");
				logger.info("My Account button displayed after successful login");
				
				hmpgObj.clickOnmyAccountButtonInMenu();
				logger.info("Click on My Account button in the menu");
				
				hmpgObj.clickOnLogOutButtonInPlayerAccountModal();
				logger.info("Click on logout from Player account modal");
				
			}
			
			if(validInvalidCredential.equalsIgnoreCase("invalid")) {
				Assert.assertEquals(hmpgObj.errorMeesageDisplayeWhenLoggedInWithInvalidCredential(), true, "My Account Button is not visible in the Menu");
				logger.info("Error message displayed when logged in with inavlid credential");
			}
			
			
			}catch (Exception e) {
			    Assert.fail(e.getMessage());
			}

			logMethodend(logger);
			
		}

}
