package AssignmentPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class RegistrationPageTest {
	
	WebDriver driver;
	RegistrationPage rpObj;
	
	@BeforeClass
	void setUp()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		driver.manage().window().maximize();
		rpObj=new RegistrationPage(driver);
	}
	
	@Test(priority=1)
	void registrationPageTest()
	{
		rpObj.txtFirstName("Moumita");
		rpObj.txtLastName("Roy");
		rpObj.txtPhoneNumber("651-567-7546");
		rpObj.txtEmailId("moumita123@gmail.com");
		rpObj.txtAddress1("3475 GolfView drive");
		rpObj.txtAddress2("Town Center drive");
		rpObj.txtCityName("Eagan");
		rpObj.txtStateName("Minnesota");
		rpObj.txtPostalCode("55123");
		rpObj.drpCountryName("INDIA");
		rpObj.txtUserName("Mou.mita");
		rpObj.txtpassWord("test1234");
		rpObj.txtConfirmPassWord("test1234");
		rpObj.clickedOnSubmitBtn();
		
	}
	
	@Test(priority=2,dependsOnMethods= {"registrationPageTest"})
	void verificationOfRegistration()
	{
		String str=rpObj.gettingConfirmMsg();
	    Assert.assertEquals(str,"Dear Moumita Roy,");
		
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}

}
