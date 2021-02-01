package Day21_DataDrivenExcell;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixedDepositeCalc {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
	    WebDriver  driver=new ChromeDriver();
	    
	    driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/"
	    		+ "fixed-deposit-calculator-SBI-BSB001.html");
	    driver.manage().window().maximize();
	    Thread.sleep(4000);
	    
	    String path="C:\\excelData\\BankTestData.xlsx";
	    
	    int rownum=XUtils.getRowCount(path,"Sheet1");
	    System.out.println("Total number of rows:"+rownum);
	    
	    
	    //reading data from the xcell
	    
	    for(int r=1; r<=rownum; r++)
	    {
	    	String price=XUtils.getCellData(path, "Sheet1", r, 0);
	    	String rateOfInterest=XUtils.getCellData(path,"Sheet1", r, 1);
	    	String period1=XUtils.getCellData(path, "Sheet1", r, 2);
	    	String period2=XUtils.getCellData(path, "Sheet1", r, 3);
	    	String freq=XUtils.getCellData(path, "Sheet1", r, 4);
	    	double mat_value=Double.parseDouble(XUtils.getCellData(path, "Sheet1", r, 5));
	    	
	    	
	    	
	    
           Thread.sleep(4000);
           
         //putting value in the application
           
          driver.findElement(By.id("principal")).sendKeys(price);
          driver.findElement(By.id("interest")).sendKeys(rateOfInterest);
          driver.findElement(By.id("tenure")).sendKeys(period1);
         
          WebElement ele1=driver.findElement(By.id("tenurePeriod"));
          Select selectTenure=new Select(ele1);
          selectTenure.selectByVisibleText(period2);
          
          Select selectFreq=new Select(driver.findElement(By.id("frequency")));
          selectFreq.selectByVisibleText(freq);
          
          driver.findElement(By.xpath("//div[@class='PT25']//a[1]//img[1]")).click();   //calculate btn
          
          
          Thread.sleep(4000);
          String act_value=driver.findElement(By.xpath("//span[@id='resp_matval']")).getText();
          
           if(Double.parseDouble(act_value)==mat_value)
           {
        	   XUtils.setCellData(path, "Sheet1", r, 7, "Pass");
        	   XUtils.fillGreenColor(path, "Sheet1",r , 7);
           }
           else
           {
        	   XUtils.setCellData(path, "Sheet1", r, 7, "Fail");
        	   XUtils.fillRedColor(path, "sheet1",r , 7);
           }
           
           driver.findElement(By.xpath("//img[@class='PL5']")).click();        //clear btn
           Thread.sleep(3000);
           
           
	    } 
	    driver.quit();
	}

}
