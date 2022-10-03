package pomClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage1 {

	//declaration
	@FindBy(xpath="//input[@id='userid']") private WebElement un;
	@FindBy(xpath="//input[@id='password']") private WebElement pass;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginBtn;
	@FindBy(xpath="//span[contains(text(),'Password should')]") private WebElement errorMsgPWD; ;
	@FindBy(xpath="//span[contains(text(),'User ID should')]") private WebElement errorMsgUN;
	
	//initialization
	public KiteLoginPage1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	
	//usage of variables in method creation
	public void inpKiteLogin1PageUsername(String username) {
		un.sendKeys(username);
	}	
	public void inpKiteLogin1PagePassword(String password) {
		pass.sendKeys(password);
	}	
	public void clickKiteLogin1PageLoginBtn() {
		loginBtn.click();			
	}
	public String getKiteLogin1PageErrorMsgPWD() {
		String actText=errorMsgPWD.getText();
		return actText;
	}	
	public String getKiteLogin1PageerrorMsgUN() {
		String actText=errorMsgUN.getText();
		return actText;
	}
}
	