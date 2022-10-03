package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import configurations.PathConfig;

public class BaseClass {
	WebDriver driver;
	
	public WebDriver initializeBrowser() {
		System.setProperty("webdriver.chrome.driver", PathConfig.chromepath);
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(PathConfig.appUrl);
		return driver;
		}
}
