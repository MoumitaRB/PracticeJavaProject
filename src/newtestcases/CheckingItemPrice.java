package newtestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckingItemPrice {
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\moumi\\Desktop\\ChromeDriver\\chromedriver.exe");
	    driver=new ChromeDriver();
	    
	    driver.get("http://practice.automationtesting.in/");
	    driver.manage().window().maximize();
	    Thread.sleep(4000);
		driver.findElement(By.xpath("//img[@title='Selenium Ruby']")).click();
		driver.findElement(By.xpath("//div//button[@class='single_add_to_cart_button button alt']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='cartcontents']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='coupon_code']")).sendKeys("krishnasakinala");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@name,'apply_coupon')]")).click();
		Thread.sleep(3000);
		String act_msg=driver.findElement(By.xpath("//div[contains(@class,'woocommerce-message')]")).getText();
        System.out.println(act_msg);
        
        
        
	}
}
