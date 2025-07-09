package avantage.entertainment.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import avantage.entertainment.testcases.BaseClass;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	
	public void onStart(ITestContext testContext) {
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="AvantageEntertainment-Test-report-"+timeStamp+".html";
		sparkReporter= new ExtentSparkReporter(".\\reports\\"+repName);
		
		sparkReporter.config().setDocumentTitle("Avantage Entertainment-Baccarat");
		sparkReporter.config().setReportName("Avantage Baccarat Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Avantage Baccarat");
		extent.setSystemInfo("Module", "Accounts");
		extent.setSystemInfo("Sub Module", "Registration");
		extent.setSystemInfo("username", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		String os=testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browserName=testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browserName);
		
		List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
	}
	
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+" got successfully executed");	
	}
	
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+" got Failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		try {
			String imgPath =new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
	}
	
	
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+" got Skipped");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
	}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
		
		//String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
		//File extentReport=new File(pathOfExtentReport);
		
		/*try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch(IOException e) {
			e.printStackTrace();
		}*/
		
		/*try {
			URI uri=new URI("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
			URL url=uri.toURL();
			
			ImageHtmlEmail email=new ImageHtmlEmail();
			email.setDataSourceResolver(new DataSourceUrlResolver(url));
			email.setHostName("smtp.googleemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("rakeshdem001@gmail.com", "Igsdata@246"));
			email.setSSLOnConnect(true);
			email.setFrom("rakeshdemo001@gmail.com");
			email.setSubject("Avantage Entertainment Automation Regression Test Results");
			email.setMsg("Please find the report attached for the recent run");
			email.addTo("rakesh062@gmail.com");
			email.attach(url,"extent report","please check report");
			email.send();
			
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
	}
	
	
	
	

}
