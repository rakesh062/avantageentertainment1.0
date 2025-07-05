package avantage.entertainment.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import avantage.entertainment.pageobjects.HomePage_PageObjects;
import avantage.entertainment.utilities.DriverManager;


public class HomePageTestCases extends BaseClass{
	
	
	
	//Test case to verify the header elements in the home page
	@Test(groups="smoke")
	public void verifyHeaderElementsInHomePage() {
		
		WebDriver driver = DriverManager.getDriver();
        driver.get("https://play.avantagegames.com/av-baccarat");
        driver.manage().window().maximize();
		HomePage_PageObjects hmpgObj=new HomePage_PageObjects(driver);
		
		logMethodStart(logger);
		
		try {
			System.out.println("Running on thread: " + Thread.currentThread().getName());

		//Using Assert.asertEquals(Boolean actual, Boolean expected, String messgae) method for validation
		//message is printed only when assertyion fails so that we know which icon or button failed to display on the header
		
		Assert.assertEquals(hmpgObj.hamburgerMenuIconVisible(), true, "Hamburger menu icon is not displayed in the header");
		logger.info("Hamburger Menu is displayed in the header menu");
		
		Assert.assertEquals(hmpgObj.languageSelectionIconVisible(), true, "Language selection icon is not displayed in the header");
		logger.info("Language Selection icon is displayed in the header menu");
		
		Assert.assertEquals(hmpgObj.helpbuttonIconVisible(), true, "help button is not displayed in the header");
		logger.info("help button is displayed in the header menu");
		
		Assert.assertEquals(hmpgObj.avantageLogoImageVisible(), true, "Avanatge logo Image is not displayed in the header");
		logger.info("Avanatge logo Image is displayed in the header menu");
		
		Assert.assertEquals(hmpgObj.myContestsIconVisible(), true, "My Contests button is not displayed in the header");
		logger.info("My Contests button is displayed in the header menu");
		
		Assert.assertEquals(hmpgObj.loginbuttonIconVisible(), true, "Login button is not displayed in the header");
		logger.info("Login button is displayed in the header menu");
		
		Assert.assertEquals(hmpgObj.joinbuttonIconVisible(), true, "Join button is not displayed in the header");
		logger.info("Join button is displayed in the header menu");
		
		}catch(Exception e) {
			Assert.fail(e.getMessage());
		
		}
	
		
		logMethodend(logger);		
		
	}
	

}
