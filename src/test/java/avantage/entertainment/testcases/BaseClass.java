package avantage.entertainment.testcases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import avantage.entertainment.utilities.DriverFactory;
import avantage.entertainment.utilities.DriverManager;



public class BaseClass {
	
	
	public WebDriver driver;
	
	public Logger logger;
	public static Properties propertiesReader;
	
	public String local_Remote_Execution;

	
	@BeforeClass(groups={"smoke","regression"})
	public void beforeClassSetUp() throws IOException {
		logger=LogManager.getLogger(this.getClass());
		FileReader propertiesFilePath= new FileReader("./src//test//resources//config.properties");
		propertiesReader=new Properties();
		propertiesReader.load(propertiesFilePath);
		local_Remote_Execution=propertiesReader.getProperty("execution_environment");
		System.out.println(local_Remote_Execution);
	}
	
    @Parameters({"os","browser"})
    @BeforeMethod(groups={"smoke","regression"})
    public void setUp(String os, String browser) throws IOException, URISyntaxException {
    	if(local_Remote_Execution.toLowerCase().equals("local")) {
    		System.out.println("I am in local");
            driver = DriverFactory.createInstanceLocal(browser);
            DriverManager.setDriver(driver);
    	}
    	
    	if(local_Remote_Execution.toLowerCase().equals("remote")) {
            driver = DriverFactory.createInstanceRemote(os,browser);
            DriverManager.setDriver(driver);
    	}


        
    }

    @AfterMethod(groups={"smoke","regression"})
    public void tearDown() {
        DriverManager.quitDriver();
    }
	
	
    public static void logMethodStart(Logger logger) {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        logger.info("************* Staring Of Test Case: {}", methodName+" ********************");
    }
    
    public static void logMethodend(Logger logger) {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        logger.info("************* End Of Test Case: {}", methodName+" ********************");
    }
    
    public String captureScreen(String tname) throws IOException{
    	
    	String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    	
    	TakesScreenshot takeScreenShot= (TakesScreenshot) DriverManager.getDriver();
    	File sourceFile=takeScreenShot.getScreenshotAs(OutputType.FILE);
    	
    	String targetFilePath=System.getProperty("user.dir")+".\\screenshots\\screenShots"+ tname +"_"+timeStamp+".png";
    	
    	File targetFile=new File(targetFilePath);
    	
    	sourceFile.renameTo(targetFile);
    	
    	return targetFilePath;
    	
    	
    }
    
    public void waitToLoadPage(WebDriver driver) {
    	JavascriptExecutor js = (JavascriptExecutor)driver;

        //This loop will rotate for 100 times to check If page Is ready after every 1 second.
        //You can replace your if you wants to Increase or decrease wait time.
        for (int i=0; i<400; i++)
        { 
            try 
            {
                Thread.sleep(1000);
            }catch (InterruptedException e) {} 
            //To check page ready state.

            if (js.executeScript("return document.readyState").toString().equals("complete"))
            { 
                break; 
            }   
          }
    }


}
