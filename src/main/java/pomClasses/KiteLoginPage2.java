package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage2 {

	//declaration
	@FindBy(xpath = "//input[@id='pin']") private WebElement pin;
	@FindBy(xpath = "//button[@class='button-orange wide']") private WebElement contBtn;	
	
	//initialization
	public KiteLoginPage2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//usage
	public void inpKiteLogin2PagePin(String pinvalue) {
		pin.sendKeys(pinvalue);
	}
	
	public void clickKiteLogin2PageContinueBtn() {
		contBtn.click();
	}
}
