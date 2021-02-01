package Day19_FileUploadAndDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class FileUpload2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Work\\drivers\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
	    try {
	    	
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.switchTo().frame(0);
		
		
		WebElement ele=driver.findElement(By.xpath("//form//div[@id='q21']//div//div//parent::div//input[@id='RESULT_FileUpload-10']"));
		
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);
		Thread.sleep(3000);
		
		Screen s=new Screen();
	    Pattern fileInputText=new Pattern("C:\\SikuliPics\\TextBox.png");
	    Pattern openBtn=new Pattern("C:\\SikuliPics\\OpenBtn1.png");
	    
	    s.wait(fileInputText,3);
	    s.type(fileInputText, "C:\\SikuliPics\\Rose.jpg");
	    s.click(openBtn);
	    
	    Thread.sleep(3000);
		
		
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
