package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	LoginPage lpObj;
	@BeforeClass
	void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		lpObj=new LoginPage(driver);
		
		
	}
	
    @Test(priority=1)
    void logoTestVerification()
    {
    	boolean b1=lpObj.logoPresence();
    	Assert.assertEquals(b1, true);
    }
    
    @Test(priority=2)
    void loginTestVerification()
    {
    	lpObj.txtUserName("Admin");
    	lpObj.txtPassWord("admin123");
    	lpObj.clickedOnloginBtn();
    	
    	String actualTitle=driver.getTitle();
    	Assert.assertEquals(actualTitle, "OrangeHRM");
    	
    }
    
    @AfterClass
    void teraDown()
    {
    	driver.quit();
    }
}
