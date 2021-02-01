package Day19_FileUploadAndDownload;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FileDownloadInFF {
	
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
		
		//Setting browser profile
		FirefoxProfile profile=new FirefoxProfile();
		
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/plain,application/pdf" );
		profile.setPreference("pdfjs.disabled", true);  // only for pdf
		
		//download files in desired location
		profile.setPreference("browser.download.folderList",0);  //0-desktop  1- Downloads  2- prefered location
		profile.setPreference("browser.download.dir","C:\\Downloads");// this statement is required if the above option is 2
				
		FirefoxOptions options=new FirefoxOptions();
		options.setProfile(profile);
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\Work\\drivers\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver(options);
		
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
		boolean status=isFileExists("C://Users//moumi//Desktop//info.txt");
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
		boolean status2=isFileExists("C://Users//moumi//Desktop//info.pdf");
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
