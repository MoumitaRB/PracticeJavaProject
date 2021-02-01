package Day18_DatePickerAndWebTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingWebTable {
	   public static WebDriver driver;
	   public static ReadingWebTable rwtObj;
	   
	   
	public  void loginBtn(WebElement username1, WebElement password1, WebElement loginBtn1,
			 String nameValue, String pwdValue) 
	{
		username1.sendKeys(nameValue);
		password1.sendKeys(pwdValue);
		loginBtn1.click();
	
		
	}
    public void adminTabClick(WebElement adminTab1, WebElement usermngTab1, WebElement userTab1)
    {
    	adminTab1.click();
    	usermngTab1.click();
    	userTab1.click();
       try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
    }

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
	    try {
	    	
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		WebElement username1=driver.findElement(By.xpath("//div//input[@id='txtUsername']"));
		WebElement password1=driver.findElement(By.id("txtPassword"));
		WebElement loginBtn1=driver.findElement(By.id("btnLogin"));
		
		rwtObj=new ReadingWebTable();
		rwtObj.loginBtn(username1, password1, loginBtn1, "Admin", "admin123");
		
//		WebElement adminTab1=driver.findElement(By.xpath("//div[@class='menu']//a[@id='menu_admin_viewAdminModule']"));
//		WebElement usermngTab1=driver.findElement(By.xpath("//div[@class='menu']//a//following-sibling::ul//li//a[@id='menu_admin_UserManagement']"));
//		WebElement userTab1=driver.findElement(By.xpath("//div[@class='menu']//a//following-sibling::ul//li//a[@id='menu_admin_viewSystemUsers']"));
		
//		rwtObj.adminTabClick(adminTab1, usermngTab1, userTab1);
//		Thread.sleep(3000);

		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		Thread.sleep(3000);
		
		List<WebElement> rows=driver.findElements(By.xpath("//table//tbody//tr"));
		System.out.println("Total number of rows:"+rows.size());
		List<WebElement> columns=driver.findElements(By.xpath("//table//tbody//tr[1]//td"));
		System.out.println("Total number of columns:"+columns.size());
		
		int enabledCounter=0;
		int disabledCounter=0;
		for(int r=2; r<=rows.size();r++)
		{
			String data=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[5]")).getText();
			if(data.equals("Enabled"))
			{
				enabledCounter=enabledCounter+1;
			}
			else
			{
				disabledCounter=disabledCounter+1;
			}
			
		}
		
		
		System.out.println("Total number of Enabled employee:"+ enabledCounter );
		System.out.println("Total number of Disabled employee:"+ disabledCounter);
		Thread.sleep(3000);
		
		for(int r=2; r<=rows.size(); r++)
		{
			for(int c=1; c<=columns.size(); c++)
			{
				String employeeData=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(employeeData+"   ");
			}
			System.out.println();
		
		}
		Thread.sleep(3000);
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

