package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public static WebDriver ldriver;
	
	LoginPage(WebDriver rdriver)
	{   
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
   
	@FindBy(xpath="//div[@id='divLogo']//img")
	WebElement logo;
	
	@FindBy(id="txtUsername")
	WebElement userName;
	
	@FindBy(id="txtPassword")
	WebElement passWord;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	
	 boolean logoPresence()
	{    
		return logo.isDisplayed();
		
	}
	
	void txtUserName(String uname)
	{
		userName.sendKeys(uname);
	}
	
	void txtPassWord(String pwd)
	{
		passWord.sendKeys(pwd);
	}
	
	void clickedOnloginBtn()
	{
		loginBtn.click();
	}
}
