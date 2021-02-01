package Day27TakeScreenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CaptureScreenshot {
	 WebDriver driver;
	
	@Test
	void screenShots() throws IOException
	{
	  System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	  driver.manage().window().maximize();
      
	  File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File trgfile=new File(System.getProperty("user.dir")+"//Screenshots//loginscreen1.png");
	  FileUtils.copyFile(srcfile, trgfile);
	  
	}
	
	
	
 
}
