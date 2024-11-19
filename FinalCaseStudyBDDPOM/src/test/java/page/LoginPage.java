package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//PageFactory pattern
		@FindBy(name = "email")
		WebElement username;
		
		@FindBy(name="password")
		WebElement pwd;
		
		@FindBy(xpath="//button[text()='Login']")
		WebElement loginBtn;
		
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void validLogin(String strUser,String strPwd) {
			username.sendKeys(strUser);
			pwd.sendKeys(strPwd);
			loginBtn.click();
			
			
		}

}
