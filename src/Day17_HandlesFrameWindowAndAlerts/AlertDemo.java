package Day17_HandlesFrameWindowAndAlerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {
	  public static AlertDemo adObj;
	
	  public void clickOnSignIn(WebElement signIn )
	  {
		  signIn.click();
	  }

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		try {
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		WebElement  signIn=driver.findElement(By.name("proceed"));
		adObj=new AlertDemo();
		adObj.clickOnSignIn(signIn);
		
		Alert alert=driver.switchTo().alert();
		String alertText=alert.getText();
		
		Thread.sleep(3000);
		
		System.out.println("Text from the alert:"+alertText);
		
		alert.accept();
		
		String title=driver.getTitle();
		System.out.println("Title of the page after accepting alert ok:"+title);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			driver.quit();
		}
	}

}
