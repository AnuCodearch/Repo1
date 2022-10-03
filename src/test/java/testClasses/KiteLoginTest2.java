package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import baseClasses.Utility;
import pomClasses.KiteLoginPage1;
import pomClasses.KiteLoginPage2;
import pomClasses.KiteLoginPage3;

//testclass-testcases
public class KiteLoginTest2 {
	
	WebDriver driver;
	BaseClass base;
	KiteLoginPage2 login2;
	KiteLoginPage1 login1;
	String TCID;
	KiteLoginPage3 home;
	
	@BeforeClass
	public void openBrowser() {
		Reporter.log("----Open Browser-----");
		base=new BaseClass();
		driver=base.initializeBrowser();
		login2=new KiteLoginPage2(driver);
	}
	
	@BeforeMethod
	public void loginToApplication() throws InterruptedException {
		Reporter.log("----login to Application-----");
		login1.inpKiteLogin1PageUsername("DAA677");
		login1.inpKiteLogin1PagePassword("Velocity@123");
		login1.clickKiteLogin1PageLoginBtn();
		Thread.sleep(3000);
		login2.inpKiteLogin2PagePin("866918");
		login2.clickKiteLogin2PageContinueBtn();
	}
	
	@Test
	public void verifyUserID() throws InterruptedException {
		TCID="201";
		Reporter.log("----running verifyUserID test script----");
		String expUserID="DAA677";
		String actUserID=home.getKiteHomePageUserID();
		Thread.sleep(5000);
		Assert.assertEquals(actUserID, expUserID);
	}
	
	@AfterMethod
	public void logoutfromApplication(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			Utility.captureScreenshot(driver, TCID);
		}
		
		Reporter.log("----logoutFromApplication----");
		home.clickKiteHomePageUserID();
		home.clickKiteHomePageLogout();
	}
	
	
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		Reporter.log("---Closed Browser----");
		driver.close();
	}
}
