package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/////homepage
public class KiteLoginPage3 {
	//declare
	@FindBy(xpath="//span[@class='user-id']") private WebElement UserID;
	@FindBy(xpath="//a[contains(text(),'Logout')]") private WebElement logout;
	@FindBy(xpath="(//button[@type='button'])[1]") private WebElement investBtn;

	
	//initiaize
	public KiteLoginPage3(WebDriver driver){
		PageFactory.initElements(driver, this);
		}

	
	//usage
	public String getKiteHomePageUserID() {
		String actText=UserID.getText();
		return actText;
	}
	
	public void clickKiteHomePageUserID() 
	{
	UserID.click();
	}
	
	public void clickKiteHomePageLogout() 
	{
	logout.click();
	}
	
	public void clickInvestBtn() {
		investBtn.click();
		}

}
