package Day20_MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DifferentMouseActionWithMethods {
	public static WebDriver driver;
	public static Actions act;
	public static JavascriptExecutor js;
	
	public static void doubleclick(WebElement inputBox1, WebElement clickBtn, String exp_Text ) throws InterruptedException
	{
		inputBox1.clear();
	    inputBox1.sendKeys(exp_Text);
	    Thread.sleep(3000);
	    act=new Actions(driver);
        act.doubleClick(clickBtn).perform();
		Thread.sleep(4000);
	}
	
	public static void validationText(WebElement text, String exp_text)
	{
		String actualText=text.getText();
		if(actualText.equals(exp_text))
        {
    	   System.out.println("Test passed");
        }
        else
        {
    	   System.out.println("Test Failed");
        }
	}
    public static void dragAndDrop1(WebElement source, WebElement target) throws InterruptedException
    {    act=new Actions(driver);
    	 act.dragAndDrop(source, target).perform();
         Thread.sleep(4000);
    }
    public static void scrollDown(String pixelArg1, String pixelArg2) throws InterruptedException
    {   
    	js= (JavascriptExecutor)driver;
    	js.executeScript(pixelArg1,pixelArg2);
        Thread.sleep(3000);
        
    }
    public static void dragAndDrop2(WebElement source2, WebElement source3, WebElement target2) throws InterruptedException
    {
    	act=new Actions(driver);
    	act.dragAndDrop(source2, target2).perform();
        Thread.sleep(4000);
        act.dragAndDrop(source3, target2).perform();
        Thread.sleep(3000);
        
    }
    
    public static void slider(WebElement slider, int xOffset, int yOffset)
    {
    	act=new Actions(driver);
    	act.dragAndDropBy(slider, xOffset, yOffset).perform();
    }
    
    public static void scrollDown2(String pixelArg3, String pixelArg2) throws InterruptedException
    {
    	js= (JavascriptExecutor)driver;
    	js.executeScript(pixelArg3,pixelArg2);
        Thread.sleep(3000);
    }
    
    public static void resizable(WebElement resizeBtn, int xOffset1, int yOffset1) throws InterruptedException
    {
    	act.dragAndDropBy(resizeBtn, xOffset1, yOffset1).perform();
    	Thread.sleep(4000);
    }
    
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
	    
	    driver.get("https://testautomationpractice.blogspot.com/");
	    driver.manage().window().maximize();
	    Thread.sleep(4000);
	    String exp_Text="Welcome to java";
	    
	    WebElement inputBox1=driver.findElement(By.id("field1"));
	    WebElement clickBtn= driver.findElement(By.xpath("//button[contains(text(),'Copy Text')]"));
	    DifferentMouseActionWithMethods.doubleclick(inputBox1, clickBtn, exp_Text);
	    
	    WebElement text=driver.findElement(By.xpath("//input[@id='field2']"));
	    DifferentMouseActionWithMethods.validationText(text, exp_Text);
	    
	    WebElement source=driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')]"));
        WebElement target=driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"));
        DifferentMouseActionWithMethods.dragAndDrop1(source, target);
        
        String pixelArg1="window.scrollBy(0,600)";
        String pixelArg2="";
        DifferentMouseActionWithMethods.scrollDown(pixelArg1,pixelArg2);
        
        WebElement source2=driver.findElement(By.xpath("//li[1]//img[1]"));
        WebElement source3=driver.findElement(By.xpath("//li[2]//img[1]"));
        WebElement target2=driver.findElement(By.xpath("//div[@id='trash']"));
        
        DifferentMouseActionWithMethods.dragAndDrop2(source2, source3, target2);
        
        WebElement slider=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
        int xOffset=250;
        int yOffset=0;
        DifferentMouseActionWithMethods.slider(slider, xOffset, yOffset);
        
        String pixelArg3="window.scrollBy(0,400)";
        DifferentMouseActionWithMethods.scrollDown2(pixelArg3, pixelArg2);
        
        WebElement  resizeBtn=driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
	    int xOffset1=200;
	    int yOffset1=100;
	    DifferentMouseActionWithMethods.resizable(resizeBtn, xOffset1, yOffset1);
	
	    driver.quit();
	    
	}

}
