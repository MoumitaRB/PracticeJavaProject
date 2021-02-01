package Day14;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {
	   
	  public static Assignment1 obj;
	 
	 
	  public void selectDateFromDropDown(WebElement dayXpath, String value)
	  {
		  Select selectDay= new Select(dayXpath);
		  selectDay.selectByVisibleText(value);
	  }
      public void selectRadioButtonForServiceClass(WebElement serviceClass)
      {
    	  
    	  serviceClass.click();
    	 
     }
      
      public void clickOnContinue(WebElement contBtn)
      {
    	  contBtn.click();
      }
      public void selectRadioButtonForFlightAirpline(WebElement pangaeaAirlines)
      {
    	  
    	  pangaeaAirlines.click();
      }
      
      public void clickOnReserveFlightBtn(WebElement reserveFlightBtn)
      {
    	  reserveFlightBtn.click();
      }
      public void selectCountryFromDropDown(WebElement countryXpath, String value )
      {
    	  Select selectCountry= new Select(countryXpath);
    	  selectCountry.selectByVisibleText(value);
      }
      
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		try {
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		WebElement radioBtn=driver.findElement(By.xpath("//input[@value='oneway']"));
		System.out.println("Displaying radio button:"+radioBtn.isDisplayed());
		System.out.println("Radio button is enable:"+radioBtn.isEnabled());
		System.out.println("Radio button is selected:"+radioBtn.isSelected());
			
			radioBtn.click();
			
		System.out.println("radio button is selected:"+radioBtn.isSelected());
		
		
		WebElement passenger=driver.findElement(By.xpath("//select[@name='passCount']"));
		Select selectPassenger=new Select(passenger);
		
		int sizePassenger=selectPassenger.getOptions().size();
		
		selectPassenger.selectByVisibleText("2");
		Thread.sleep(2000);
		
		System.out.println("Size of the passenger:"+sizePassenger);
		
		List<WebElement>passengerList= selectPassenger.getOptions();
		for(WebElement pList:passengerList)
		{    
			
			System.out.println(pList.getText());
			
		}
		
		WebElement deptFrom=driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select selectdeptFrom=new Select(deptFrom);
        
        int departureSize= selectdeptFrom.getOptions().size();
        System.out.println("Size of the departure:"+departureSize);
        
        selectdeptFrom.selectByValue("Paris");
        Thread.sleep(2000);
        
        List<WebElement>departureList=selectdeptFrom.getOptions();
        for(WebElement dList:departureList)
        {
        	System.out.println(dList.getText());
        }
        
        
        WebElement month=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select selectMonth=new Select(month);
        
        int totalMonth= selectMonth.getOptions().size();
        System.out.println("Size of the months:"+totalMonth);
        
        selectMonth.selectByVisibleText("September");
        Thread.sleep(2000);
        
        List<WebElement>monthList=selectMonth.getOptions();
        for(WebElement mList:monthList)
        {
        	System.out.println(mList.getText());
        }
        
        
        WebElement day=driver.findElement(By.xpath("//select[@name='fromDay']"));
        WebElement contBtn=driver.findElement(By.xpath("//input[@name='findFlights']"));
        
        obj=new Assignment1 ();
        obj.selectDateFromDropDown(day, "10");
        Thread.sleep(2000);
        
        WebElement serviceClass=driver.findElement(By.xpath("//input[@value='Business']"));
        obj.selectRadioButtonForServiceClass(serviceClass);
        
        
        obj.clickOnContinue(contBtn);
        Thread.sleep(2000);
        
  
        WebElement pangaeaAirlines=driver.findElement(By.xpath("//input[@name='outFlight'][@value='Pangea Airlines$362$274$9:17']"));
        obj.selectRadioButtonForFlightAirpline(pangaeaAirlines);
        Thread.sleep(2000);
        
        WebElement reserveFlightBtn=driver.findElement(By.name("reserveFlights"));
		obj.clickOnReserveFlightBtn(reserveFlightBtn);
		
		WebElement firstName=driver.findElement(By.name("passFirst0"));
		firstName.sendKeys("Moumita");
		WebElement lastName=driver.findElement(By.name("passLast0"));
		lastName.sendKeys("Roy");
		WebElement meal=driver.findElement(By.name("pass.0.meal"));
		Select selectMeal=new Select(meal);
		selectMeal.selectByVisibleText("Hindu");
		
		WebElement creditNumber=driver.findElement(By.name("creditnumber"));
		creditNumber.sendKeys("0278926763291");
	
		WebElement billingAddress=driver.findElement(By.name("billAddress1"));
		billingAddress.sendKeys("3475 GolfView Drive");
		WebElement city=driver.findElement(By.name("billCity"));
		city.sendKeys("Eagan");
		WebElement state=driver.findElement(By.name("billState"));
		state.sendKeys("Minnesota");
		WebElement postalCode=driver.findElement(By.name("billZip"));
		postalCode.sendKeys("55123");
		
		WebElement countryXpath= driver.findElement(By.name("billCountry"));
		obj.selectCountryFromDropDown(countryXpath, "INDIA");
		
		WebElement checkBox=driver.findElement(By.xpath("//form//table//tbody//tr[@bgcolor='#CCCCCC'][2]//td[2]//font/preceding-sibling::input[@type='checkbox']"));
		checkBox.click();
		
		
		Thread.sleep(3000);
		
		WebElement purchaseTicketBtn=driver.findElement(By.name("buyFlights"));
		purchaseTicketBtn.click();
		Thread.sleep(2000);
		
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		
		String expectedTitle="Flight Confirmation: Mercury Tours";
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Test Passed...");
		}
		else
		{
			System.out.println("Test Failed...");
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			driver.close();
		}

	}

}
