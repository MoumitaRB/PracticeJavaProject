package newtestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class ArrivalsImageBookAddToBasket_006{
	public static WebDriver driver;

	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\moumi\\Desktop\\ChromeDriver\\chromedriver.exe");
		    driver=new ChromeDriver();
		    
		    driver.get("http://practice.automationtesting.in/");
		    driver.manage().window().maximize();
		    Thread.sleep(4000);
		    driver.findElement(By.xpath("//a//img[@title='Selenium Ruby']")).click();
			//driver.findElement(By.xpath("//input[@name='quantity']")).click();
			//driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("1");
			
			driver.findElement(By.xpath("//div//button[@class='single_add_to_cart_button button alt']")).click();
			Thread.sleep(3000);
//			driver.findElement(By.xpath("//a[contains(@class,'button wc-forward')]")).click();
//			Thread.sleep(3000);
//			List<WebElement>rownum=driver.findElements(By.xpath("//table//tbody//tr"));
//			for(int r=1; r<rownum.size(); r++)
//			{
//				String act_bookname=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[3]")).getText();
//				if(act_bookname.contains("Selenium Ruby"))
//				{
//					String act_price=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[6]")).getText();
//					
//					
//					if(act_price.contains("500.00"))
//					{
//						System.out.println("true");
//						
//					}
//					else
//					{
//						System.out.println("false");
//					}
//					break;
//				}
//				
//			}
//			
			String act_msg=driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText();
			System.out.println(act_msg);
			if(act_msg.contains("“Selenium Ruby” has been added to your basket."))
			{
				System.out.println("true");
			}
			else
			{
				System.out.println("false");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

}
}