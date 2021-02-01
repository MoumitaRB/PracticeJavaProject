package Day18_DatePickerAndWebTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebTableCheck {
	   public static WebDriver driver;
	   public static WebTableCheck wtObj;
	   
	public void addingStudent(WebElement name,WebElement contact, WebElement subjectList, WebElement mark, WebElement submitBtn,
			String nameValue, String contactValue, String subjectValue, String markValue ) 
	{
		name.sendKeys(nameValue);
		contact.sendKeys(contactValue);
		
		subjectList.click();
		Select selectSub=new Select(subjectList);
		selectSub.selectByVisibleText(subjectValue);
		
		mark.sendKeys(markValue);
		submitBtn.click();
		
				
	}
	
	public void editingMark(WebElement editBtn, WebElement mark, WebElement submitBtn, String markValue )
	{
		editBtn.click();
		mark.clear();
		mark.sendKeys(markValue);
		submitBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
    public void validatingEditMark(WebElement editMark, String markValue)
    {
    	String str=editMark.getText();
    	if(str.equals(markValue))
    	{
    		System.out.println("Mark Updated...");
    	}
    	else
    	{
    		System.out.println("Mark didn't update");
    	}
    }
    public void deletingData(List<WebElement> deleteBtn)
    {
    	for(WebElement ele:deleteBtn)
    	{
    		ele.click();
    	}
    }
   
    public void validatingDeleteData(WebElement deleteData)
    {
    	String str=deleteData.getText();
    	if(str.equals("No Data Found"))
    	{
    		System.out.println("Data removed...");
    	}
    	else
    	{
    		System.out.println("Data is not removed...");
    	}
    }
	
    public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		try {
			
			driver.get("http://www.trycatchclasses.com/code/demo/angular4_crud/");
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
		WebElement contact= driver.findElement(By.xpath("//input[@name='contact']"));
		WebElement subjectList=driver.findElement(By.xpath("//select[@name='subject']"));
		WebElement mark=driver.findElement(By.xpath("//input[@name='marks']"));
		WebElement submitBtn= driver.findElement(By.xpath("//input[@value='Submit']"));
		
		
		wtObj=new WebTableCheck();
		wtObj.addingStudent(name, contact, subjectList, mark, submitBtn, "Dina", "8956123456", "Angular", "78");
		wtObj.addingStudent(name, contact, subjectList, mark, submitBtn, "Smith","3567797912", "HTML", "60");
		wtObj.addingStudent(name, contact, subjectList, mark, submitBtn, "Jack", "1234567890", "JS", "94");
		
		List<WebElement> row=driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody//tr"));
		System.out.println(row.size());
		List<WebElement> column=driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody//tr[1]//td"));
		System.out.println(column.size());
		
		for(int r=1;r<=row.size(); r++)
		{
			for(int c=1; c<=column.size(); c++)
			{
				String stuData=driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(stuData+"   ");
			}
			System.out.println();
		}
		 
		 Thread.sleep(3000);
		 
		 WebElement editBtn=driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody//tr[3]//button[text()='Edit']"));
		 wtObj.editingMark(editBtn, mark, submitBtn, "100");
		 
		 WebElement editMark= driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody//tr[3]//td[5]"));
		 wtObj.validatingEditMark(editMark, "100");
		 
		 List<WebElement> deleteBtn= driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody//tr//td[7]"));
		 wtObj.deletingData(deleteBtn);
		 Thread.sleep(2000);
		 
		 WebElement deleteData= driver.findElement(By.xpath("//h6[text()='No Data Found']"));
		 wtObj.validatingDeleteData(deleteData);
		 
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
	
	


