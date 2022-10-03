package testClasses;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
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

//testclass
public class KiteLoginTest1 {

	WebDriver driver;
	BaseClass base;
	KiteLoginPage1 login1;
	String tcID;
	
	@BeforeClass
	public void openBrowser() {
		Reporter.log("---Open Browser---",true);
		base=new BaseClass();                 /////---
		driver = base.initializeBrowser();    /////--call baseclass non-static-method
		login1=new KiteLoginPage1(driver);    ////--we want to test login page elements so create object of its pom class
	}
	
	@BeforeMethod
	public void beforemethod_refresh() {
		driver.navigate().refresh();
	}
	
	@Test
	public void LoginScenario1_EnterOnly_UserID() throws EncryptedDocumentException, IOException {
		tcID="102";
		Reporter.log("----TC Name: Login Negative Test - Blank Password---",true);
		login1.inpKiteLogin1PageUsername(Utility.getExcelData(1,0));   //ENter User ID
		login1.clickKiteLogin1PageLoginBtn();                          //CLick on Login Button
		String actErrorMsg=login1.getKiteLogin1PageErrorMsgPWD();      // get Text form application
		String expErrorMsg="Password should be minimum 6 characters."; //Expected error 
		Assert.assertEquals(actErrorMsg, expErrorMsg);            //Verification
	}
	
	@Test
	public void LoginScenario2_EnterOnly_Password() throws EncryptedDocumentException, IOException {
		tcID="103";
		Reporter.log("----TC Name: Login Negative Test - Blank Username---",true);
		login1.inpKiteLogin1PagePassword(Utility.getExcelData(1,3));   //ENter Username
		login1.clickKiteLogin1PageLoginBtn();                          //CLick on Login Button
		String actErrorMsg=login1.getKiteLogin1PageerrorMsgUN();      // get Text form application
		String expErrorMsg="User ID should be minimum 6 characters."; //Expected error 
		Assert.assertEquals(actErrorMsg, expErrorMsg);            //Verification
	}
	
	@Test
	public void LoginScenario3_EnterNothing() {
		tcID="104";
		Reporter.log("----TC Name: Login Negative Test - Blank Username & Password---",true);
		login1.clickKiteLogin1PageLoginBtn();                          //CLick on Login Button
		String actErrorMsg=login1.getKiteLogin1PageerrorMsgUN();      // get Text form application
		String expErrorMsg="User ID should be minimum 6 characters."; //Expected error 
		Assert.assertEquals(actErrorMsg, expErrorMsg);            //Verification
	}
	
	
	@AfterMethod
	public void takesceenshot (ITestResult result) throws IOException {
		if (ITestResult.FAILURE==result.getStatus()) {
			Utility.captureScreenshot(driver, tcID);
		}
	}
	
	
	@AfterClass
	public void closeBrowser() {
		Reporter.log("-----close Browser-----");
		driver.close();
	}
	
	
	
	
	
	
	
	
}
