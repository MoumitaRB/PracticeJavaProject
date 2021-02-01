package Day15;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindRadioButton {
	public static FindRadioButton frObj;
	
	 public void readingRadioButtonText(List<WebElement> radio)
	 {
		 for(WebElement e:radio)
		 {
		    String s= e.getText();
		    System.out.println(s);
		 }
	 }
	

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		try {
		driver.get("http://newtours.demoaut.com/mercuryreservation.php");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		List<WebElement>radio=driver.findElements(By.xpath("//input[@type='radio']"));
		int radioBtnSize=radio.size();
		System.out.println(radioBtnSize);
		
		frObj=new FindRadioButton();
		frObj.readingRadioButtonText(radio);
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
