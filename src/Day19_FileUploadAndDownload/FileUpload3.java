package Day19_FileUploadAndDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

public class FileUpload3 {

	public static void main(String[] args) throws InterruptedException, SikuliException {
		System.setProperty("webdriver.gecko.driver", "C:\\Work\\drivers\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://html.com/input-type-file/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		WebElement ele=driver.findElement(By.xpath("//input[@id='fileupload']"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);
		Thread.sleep(3000);
		
		Screen s=new Screen();
	    Pattern fileInputText=new Pattern("C:\\SikuliPics\\TextBox.png");
	    Pattern openBtn=new Pattern("C:\\SikuliPics\\OpenBtn1.png");
	    
	    s.wait(fileInputText,3);
	    s.type(fileInputText, "C:\\SikuliPics\\Rose.jpg");
	    s.click(openBtn);
	    Thread.sleep(4000);
	    
	    driver.findElement(By.xpath("//input[2]")).click();
	    String act_Text=driver.findElement(By.xpath("//h1[@class='title-page']")).getText();
	    
	    if(act_Text.equals("Oops! That page can’t be found."))
	    {
	    	System.out.println("Test Passed..");
	    }
	    else
	    {
	    	System.out.println("Test Failed...");
	    }
	}

}


//https://html.com/input-type-file/