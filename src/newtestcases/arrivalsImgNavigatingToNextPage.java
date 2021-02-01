package newtestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class arrivalsImgNavigatingToNextPage {

	public static WebDriver driver;
	public static List<WebElement> arrivalImges;

	public static void main(String[] args) throws InterruptedException, StaleElementReferenceException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\moumi\\Desktop\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();

		driver.get("http://practice.automationtesting.in/");
		driver.manage().window().maximize();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//a[contains(text(),'Shop')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();

		arrivalImges= driver.findElements(By.xpath("//a[@class='woocommerce-LoopProduct-link']//img"));
		int imageCount = arrivalImges.size();

		for(int count=0; count<imageCount; count++)
		{  
			arrivalImges= driver.findElements(By.xpath("//a[@class='woocommerce-LoopProduct-link']//img"));
			WebElement img = arrivalImges.get(count);
			img.click();
			Thread.sleep(3000);
			String act_title=driver.findElement(By.xpath("//img[@class='attachment-shop_single size-shop_single wp-post-image']")).getAttribute("title");
			Thread.sleep(3000);
			if(act_title.equals("Selenium Ruby")||act_title.equals("Thinking in HTML")||act_title.equals("Mastering JavaScript"))
			{  
				boolean b1=driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']")).isEnabled();
				Thread.sleep(3000);
				if(b1==true)
				{
					System.out.println("true");
				}
				else
				{
					System.out.print("false");
				}
			}
			
			
			driver.navigate().back();
		}
	}

}