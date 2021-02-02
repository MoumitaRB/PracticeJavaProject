package Day19_FileUploadAndDownload;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class FileUpload {
	
	 public static WebDriver driver;
	   public static FileUpload fuObj;
	   
	   
	public  void loginBtn(WebElement username1, WebElement password1, WebElement loginBtn1,
			 String nameValue, String pwdValue) 
	{
		username1.sendKeys(nameValue);
		password1.sendKeys(pwdValue);
		loginBtn1.click();
	
		
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Work\\drivers\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		
	    try {
	    	
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement username1=driver.findElement(By.xpath("//div//input[@id='txtUsername']"));
		WebElement password1=driver.findElement(By.id("txtPassword"));
		WebElement loginBtn1=driver.findElement(By.id("btnLogin"));
		
		fuObj=new FileUpload();
		fuObj.loginBtn(username1, password1, loginBtn1, "Admin", "admin123");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
		//driver.findElement(By.xpath("//input[@name='btnAdd']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li//a[@id='menu_pim_addEmployee']")).click();
        Thread.sleep(3000);
		
          //by sendkeys we can upload files
        
		//driver.findElement(By.id("photofile")).sendKeys("C:\\Uploadpic\\Sikuli.jpg");
        
		//driver.findElement(By.id("photofile")).click();   //not working
        
        WebElement choosefile=driver.findElement(By.id("photofile"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", choosefile);     //click button working with javascript
		
		Thread.sleep(2000);
		
		Screen s= new Screen();
		Pattern fileInputTextBox= new Pattern("C:\\SikuliPics\\TextBox.png");
		Pattern openBtn= new Pattern("C:\\SikuliPics\\OpenBtn1.png");
		s.wait(fileInputTextBox, 4);
		
		
		s.type(fileInputTextBox, "C:\\SikuliPics\\Rose.jpg");
		s.click(openBtn);
		
		Thread.sleep(4000);
		
		
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
