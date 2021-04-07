package Day19_FileUploadAndDownload;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class Youtube {
	 
	public static WebDriver driver;

	public static void main(String[] args) throws FindFailed, InterruptedException {
		
		System.setProperty("webdriver.gecko.driver","C:\\Work\\drivers\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	    JavascriptExecutor js=(JavascriptExecutor)driver;
//	    js.executeScript("window.scrollBy(0,500)", "");
	
		
		
    
       
	}

}
