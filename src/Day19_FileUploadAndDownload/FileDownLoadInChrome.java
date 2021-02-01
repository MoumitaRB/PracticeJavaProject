package Day19_FileUploadAndDownload;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class FileDownLoadInChrome {
	  public static WebDriver driver;
	  
	public static boolean isFileExists(String location)
	{
		File f= new File(location);
		if(f.exists())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		 //**Script for download files in desired location
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory","C:\\Downloads");
         
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
         //****
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	    
	    
		
		boolean b1=driver.findElement(By.id("createTxt")).isEnabled();
		System.out.println(b1);
		driver.findElement(By.id("textbox")).sendKeys("Downloading text file");
		
		boolean b2=driver.findElement(By.id("createTxt")).isEnabled();
		System.out.println(b2);
		
		driver.findElement(By.id("createTxt")).click();
		driver.findElement(By.id("link-to-download")).click(); 
		
		Thread.sleep(4000);
		boolean status=isFileExists("C://Users//moumi//Downloads//info.txt");
		if(status==true)
		{
			System.out.println("Text File downloaded succesfully..");
		}
		else
		{
			System.out.println("Text File did NOT download");
		}
		
		boolean b3=driver.findElement(By.id("createPdf")).isDisplayed();
		System.out.println(b3);
		
		driver.findElement(By.id("pdfbox")).sendKeys("Downloading pdf file");
		
		boolean b4=driver.findElement(By.id("createPdf")).isDisplayed();
		System.out.println(b4);
		
		
		driver.findElement(By.id("createPdf")).click();
		driver.findElement(By.id("pdf-link-to-download")).click();
		Thread.sleep(4000);
		boolean status2=isFileExists("C://Users//moumi//Downloads//info.pdf");
		if(status2==true)
		{
			System.out.println("Pdf file downloaded successfully...");
		}
		else
		{
			System.out.println("Pdf file did not download...");
		}
		
		driver.quit();

	}

}
