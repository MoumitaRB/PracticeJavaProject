package newtestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateBasketChecking {
    
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
//		driver.findElement(By.xpath("//input[@title='Qty']")).clear();"
//		driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("3");"
//		driver.findElement(By.xpath("//div//input[@name='update_cart']")).click();"
		Thread.sleep(3000);
		boolean flag1=false;
		boolean flag2=false;
		//Double actP=0.0;
//		List<WebElement>rownum=driver.findElements(By.xpath("//table[@class='shop_table shop_table_responsive cart']//tbody//tr"));
//		System.out.println(rownum.size());
//		for(int r=1; r<rownum.size(); r++)
//		{
//			String act_name=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[3]")).getText();
//			System.out.println(act_name);
//			if(act_name.contains("Mastering JavaScript"))
//			{
//				String act_price=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[6]//span")).getText();
//				System.out.println(act_price);
//			   // actP= Double.parseDouble(act_price);
//				if(act_price.contains("1,050.00"))
//				{
//					flag= true;
//					System.out.println("true");
//					break;
//					
//				}
//				else
//				{
//					System.out.println("false");
//				}	
//		    }
//			if(flag=true)
//			{
//				break;
//			}
//		}
		
		
		
		List<WebElement>rownum=driver.findElements(By.xpath("//table[@class='shop_table shop_table_responsive']//tbody//tr"));
		System.out.println(rownum.size());
		for(int r=1; r<=rownum.size(); r++)
		{
			String act_subtotal=driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive']//tbody//tr["+r+"]//td//span")).getText();
			if(act_subtotal.contains("350.00"))
			{   
				flag1=true;
				System.out.println("true");
				
			}
		}
		
		for(int r=1; r<=rownum.size(); r++)
		{
			String act_total=driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive']//tbody//tr["+r+"]//td//span")).getText();
			if(act_total.contains("367.50"))
			{   
				flag2=true;
				System.out.println("true");
				
			}
		}
		
		if((flag1==true) && (flag2==true))
		{
			System.out.println("true");
		}
	}

}
