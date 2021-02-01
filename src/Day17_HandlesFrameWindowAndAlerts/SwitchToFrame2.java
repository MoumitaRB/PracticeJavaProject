package Day17_HandlesFrameWindowAndAlerts;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SwitchToFrame2 {
	
	
	public static WebDriver driver;
	public static SwitchToFrame2 obj;
	
	public void switchToFrame(WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	public void fillingForm(WebElement fName, WebElement lName, WebElement phNum, 
			    WebElement country,WebElement city, WebElement email, WebElement femaleRadioBtn, WebElement tuesdayCheckBox, 
			    WebElement thursdayCheckBox , WebElement bestTime,WebElement submitBtn,String value1, String value2,String value3, String value4, String value5, String value6,String value7) throws InterruptedException
	{
	       fName.sendKeys(value1);
	       lName.sendKeys(value2);
	       phNum.sendKeys(value3);
	       country.sendKeys(value4);
	       city.sendKeys(value5);
	       email.sendKeys(value6);
	       
	       // femaleRadioBtn.click();
	       
	       JavascriptExecutor js=(JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", femaleRadioBtn);
		   
	       tuesdayCheckBox.click();
	       thursdayCheckBox.click();
	       
	       Select selectTime=new Select(bestTime);
	       selectTime.selectByVisibleText(value7);
	       Thread.sleep(3000);
	       
	       submitBtn.click();
	}
			

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		try {
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		WebElement ele=driver.findElement(By.xpath("//iframe[@id='frame-one1434677811']"));
		obj=new SwitchToFrame2();
		obj.switchToFrame(ele);
		
		
		
		
		WebElement fName=driver.findElement(By.xpath("//*[@id='RESULT_TextField-1']"));
		WebElement lName=driver.findElement(By.xpath("//*[@id='RESULT_TextField-2']"));
		WebElement phNum=driver.findElement(By.xpath("//*[@id='RESULT_TextField-3']"));
		WebElement country=driver.findElement(By.xpath("//*[@id='RESULT_TextField-4']"));
		WebElement city=driver.findElement(By.xpath("//*[@id='RESULT_TextField-5']"));
		WebElement email=driver.findElement(By.xpath("//*[@id='RESULT_TextField-6']"));
		
		WebElement femaleRadioBtn=driver.findElement(By.id("RESULT_RadioButton-7_1"));
		
//		WebElement femaleRadioBtn=driver.findElement(By.xpath("//div//span[text()='Gender']/parent::div//table//tbody//tr[2]//td//input[@id='RESULT_RadioButton-7_1']/parent::td//label[text()='Female']"));
		
		WebElement tuesdayCheckBox=driver.findElement(By.xpath("//tbody//tr//td//input[@id='RESULT_CheckBox-8_2']/parent::td//label[text()='Tuesday']"));
		WebElement thursdayCheckBox=driver.findElement(By.xpath("//tbody//tr//td//input[@id='RESULT_CheckBox-8_4']/parent::td//label[text()='Thursday']"));
		
		WebElement bestTime=driver.findElement(By.id("RESULT_RadioButton-9"));
		WebElement submitBtn=driver.findElement(By.id("FSsubmit"));
		
		obj.fillingForm(fName, lName, phNum, country, city, email, femaleRadioBtn, tuesdayCheckBox, thursdayCheckBox, bestTime,submitBtn, 
				"Moumita","Roy","651-333-6789","United States","Eagan","moumitabasak@gmail.com","Morning");
		
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
