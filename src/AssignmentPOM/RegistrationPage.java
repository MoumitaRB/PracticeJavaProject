package AssignmentPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
    WebDriver ldriver;
    
    RegistrationPage(WebDriver rdriver)
    {
    	ldriver=rdriver;
    	PageFactory.initElements(ldriver, this);
    }
    
    @FindBy(name="firstName")
    WebElement fName;
    
    @FindBy(name="lastName")
    WebElement lName;
    
    @FindBy(name="phone")
    WebElement ph;
    
    @FindBy(id="userName")
    WebElement email;
    
    @FindBy(name="address1")
    WebElement address_1;
    
    @FindBy(name="address2")
    WebElement address_2;
    
    @FindBy(name="city")
    WebElement cityName;
    
    @FindBy(name="state")
    WebElement stateName;
    
    @FindBy(name="postalCode")
    WebElement pin;
    
    @FindBy(name="country")
    WebElement countryName;
    
    @FindBy(id="email")
    WebElement userName;
    
    @FindBy(name="password")
    WebElement pwd;
    
    @FindBy(name="confirmPassword")
    WebElement cofmPwd;
    
    @FindBy(name="register")
    WebElement submitBtn;
    
    @FindBy(xpath="//b[contains(text(),'Dear Moumita Roy,')]")
    WebElement text;
    
    void txtFirstName(String fname)
    {
    	fName.sendKeys(fname);
    }
    
    void txtLastName(String lname)
    {
    	lName.sendKeys(lname);
    }
    
    void txtPhoneNumber(String phno)
    {
    	ph.sendKeys(phno);
    }
    
    void txtEmailId(String emailid)
    {
    	email.sendKeys(emailid);
    }
    
    void txtAddress1(String add1)
    {
    	address_1.sendKeys(add1);
    }
    
    void txtAddress2(String add2)
    {
    	address_2.sendKeys(add2);
    }
    
    void txtCityName(String city)
    {
    	cityName.sendKeys(city);
    }
    
    void txtStateName(String state)
    {
    	stateName.sendKeys(state);
    }
    void txtPostalCode(String pincode)
    {
    	pin.sendKeys(pincode);
    }
    
    void drpCountryName(String country)
    {
    	Select select=new Select(countryName);
    	select.selectByVisibleText(country);
    }
    
    void txtUserName(String username)
    {
    	userName.sendKeys(username);
    }
    
    void txtpassWord(String pword)
    {
    	pwd.sendKeys(pword);
    }
    
    void txtConfirmPassWord(String cpWord)
    {
    	cofmPwd.sendKeys(cpWord);
    }
    
    void clickedOnSubmitBtn()
    {
    	submitBtn.click();
    }
    
    String gettingConfirmMsg()
    {   
    	String act_text=text.getText();
    	System.out.println(act_text);
		return act_text;
    	
    }
}
