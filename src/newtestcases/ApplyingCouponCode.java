package newtestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplyingCouponCode {
   
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\moumi\\Desktop\\ChromeDriver\\chromedriver.exe");
	    driver=new ChromeDriver();
	    
	    driver.get("http://practice.automationtesting.in/");
	    driver.manage().window().maximize();
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//a//img[@title='Selenium Ruby']")).click();
	    driver.findElement(By.xpath("//div//button[@class='single_add_to_cart_button button alt']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@class,'button wc-forward')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='coupon_code']")).sendKeys("krishnasakinala");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@name,'apply_coupon')]")).click();
		driver.findElement(By.xpath("//a[contains(@class,'checkout-button button alt wc-forward')]")).click();
		Thread.sleep(3000);
		List<WebElement>totalRow=driver.findElements(By.xpath("//table[@class='shop_table woocommerce-checkout-review-order-table']//tfoot//tr"));
		//List<WebElement>totalRow=driver.findElements(By.xpath("//table[@class='shop_table shop_table_responsive']//tbody//tr"));
		
		System.out.println(totalRow.size());
		
		for(int r=1; r<=totalRow.size(); r++)
		{ boolean flag=false;
		
			String couponName=driver.findElement(By.xpath("//table[@class='shop_table woocommerce-checkout-review-order-table']//tfoot//tr["+r+"]//th")).getText();
		    //String couponName=driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive']//tbody//tr["+r+"]//th")).getText();
			System.out.println(couponName);
			if(couponName.contains("Coupon: krishnasakinala"))
			{
				String act_text=driver.findElement(By.xpath("//table[@class='shop_table woocommerce-checkout-review-order-table']//tfoot//tr["+r+"]//td//span")).getText();
				System.out.println(act_text);
			    if(act_text.contains("50.00"))
			    {   
			    	flag=true;
			    	System.out.println("true");
			    
			    }
			    else
			    {   
			    	flag=false;
			    	System.out.println("false");
			    }
			  if(flag=true)
			   {
				   break;
			   }
			 }
			
		}
		
	}


}