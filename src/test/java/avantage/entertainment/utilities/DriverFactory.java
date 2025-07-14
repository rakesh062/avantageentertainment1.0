package avantage.entertainment.utilities;


import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;




public class DriverFactory {
	
	
	public static WebDriverWait wait;
	
    public static WebDriver createInstanceLocal(String browser) throws IOException {
    	
		
		WebDriver driver;
		ChromeOptions chromeOptions;
		//EdgeOptions edgeOptions;
    	
			System.out.println("under local");
			HashMap<String, Object> prefs=new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			
			

			
		switch(browser.toLowerCase()) {
		case "chrome" : chromeOptions=new ChromeOptions();
						chromeOptions.setExperimentalOption("prefs", prefs);
						chromeOptions.addArguments("--incognito");
						chromeOptions.addArguments("--headless");
						driver=new ChromeDriver(chromeOptions);
						System.out.println("Chrome driver set up completed");
						wait=new WebDriverWait(driver, Duration.ofSeconds(10));
						break;
						
		case "edge" : EdgeDriverService service = new EdgeDriverService.Builder()
			          .usingDriverExecutable(new File(".\\driver\\msedgedriver.exe"))
			          .usingAnyFreePort()
			          .build();

					EdgeOptions options = new EdgeOptions();
					options.addArguments("--headless=new");
					options.addArguments("--remote-debugging-port=9222");
					options.addArguments("--no-sandbox");
					options.addArguments("--disable-dev-shm-usage");
					options.addArguments("--disable-gpu");
					options.addArguments("--disable-extensions");

					  driver=new EdgeDriver(service,options);
					  System.out.println("Edge driver set up completed");
					  wait=new WebDriverWait(driver, Duration.ofSeconds(10));
					  break;
					  
		//case "firefox" : driver=new FirefoxDriver(); break;
		
		default:
            throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		 return driver;
		
    }
    
public static WebDriver createInstanceRemote(String os, String browser) throws IOException, URISyntaxException {
    	
		
		WebDriver driver;
		ChromeOptions chromeOptions;
		//EdgeOptions edgeOptions;
    	
			HashMap<String, Object> prefs=new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			
		
			System.out.println("under remote");
			
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			switch(os.toLowerCase()) {
			case "windows" : capabilities.setPlatform(Platform.WIN11);
							 break;
							 
			case "linux" : capabilities.setPlatform(Platform.MAC);
			 				 break;
			 				 
			case "mac" : capabilities.setPlatform(Platform.LINUX);
			 			 break;
			 			 
			default:
	            throw new IllegalArgumentException("Unsupported browser: " + browser);
			}
			
			switch(browser.toLowerCase()) {
			
			case "chrome" : capabilities.setBrowserName("chrome");
							chromeOptions=new ChromeOptions();
							chromeOptions.setExperimentalOption("prefs", prefs);
							capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
							driver=new RemoteWebDriver(new URI("http://192.168.1.38:4444/wd/hub").toURL(), capabilities);
							System.out.println("chrome driver setup done");
							break;
							
							
			case "edge" : 	capabilities.setBrowserName("MicrosoftEdge");
							driver=new RemoteWebDriver(new URI("http://192.168.1.38:4444/wd/hub").toURL(), capabilities);
							System.out.println("edge driver setup done");
							break;
							
			
			case "firefox" :capabilities.setBrowserName("firefox");
							driver=new FirefoxDriver(); break;
			
			default:
	            throw new IllegalArgumentException("Unsupported browser: " + browser);
			}
			 
			return driver;
    }

}
