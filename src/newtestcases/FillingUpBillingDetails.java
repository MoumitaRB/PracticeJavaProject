package newtestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FillingUpBillingDetails {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\moumi\\Desktop\\ChromeDriver\\chromedriver.exe");
	    driver=new ChromeDriver();
	    
	    driver.get("http://practice.automationtesting.in/");
	    driver.manage().window().maximize();
	    Thread.sleep(4000);
		driver.findElement(By.xpath("//img[@title='Mastering JavaScript']")).click();
		driver.findElement(By.xpath("//div//button[@class='single_add_to_cart_button button alt']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(@class,'button wc-forward')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@class,'checkout-button button alt wc-forward')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("billing_first_name")).sendKeys("Amir");
		driver.findElement(By.id("billing_last_name")).sendKeys("Khan");
		driver.findElement(By.id("billing_email")).sendKeys("amir123@gmail.com");
		driver.findElement(By.xpath("//div[@id='s2id_billing_country']//b")).click();
		driver.findElement(By.id("s2id_autogen1_search")).sendKeys("India");
		 List<WebElement>countryList=driver.findElements(By.xpath("//ul[@id='select2-results-1']//li//div"));
		  for(WebElement country:countryList)
		  {
			 String act_country= country.getText();
			 System.out.println(act_country);
			 if(act_country.equals("India"))
			 {
				 country.click();				 
			 }
		  }
		  driver.findElement(By.xpath("//a[@class='select2-choice select2-default']//b")).click();
		
		 WebElement ele= driver.findElement(By.xpath("//div[@class='select2-search']//input[@id='s2id_autogen2_search']"));
		 JavascriptExecutor js= (JavascriptExecutor) driver;
	     js.executeScript("arguments[0].click()", ele);
	     ele.sendKeys("Karnataka");
		  
		
		//driver.findElement(By.xpath("//input[@id='s2id_autogen460_search']")).sendKeys("Karnataka");
		List<WebElement>statesList =driver.findElements(By.xpath("//ul[@id='select2-results-2']//li//div"));
		System.out.println(statesList.size());
		for(WebElement state:statesList)
		{   
			String act_state=state.getText();
			if(act_state.equals("Karnataka"))
			{
				state.click();
			}
		}
		
		//JavascriptExecutor js= (JavascriptExecutor) driver;
       // js.executeScript("arguments[0].sendKeys()", ele);
		// ele.sendKeys("Karnataka");
		 
		 // driver.findElement(By.xpath("//span[@class='select2-match']")).click();
	}

}
