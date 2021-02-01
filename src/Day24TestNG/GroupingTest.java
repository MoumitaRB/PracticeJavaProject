package Day24TestNG;

import org.testng.annotations.Test;

public class GroupingTest {

	@Test(groups= {"Sanity Test", "Regression Test"})
	void loginByEmail()
	{
		System.out.println("Login By Email.....");
	}
	
	@Test(groups= {"Sanity Test"})
	void loginByFacebook()
	{
		System.out.println("Login By FaceBook.....");
	}
	
	@Test(groups= {"Regression Test"})
	void loginByTwitter()
	{
		System.out.println("Login By Twitter.....");
	}
	
	@Test(groups= {"Sanity Test","Regression Test"})
	void signUpByEmail()
	{
		System.out.println("Sign up By Email.....");
	}
	
	@Test(groups= {"Sanity Test"})
	void signUpByFacebook()
	{
		System.out.println("Sign up by Facebook.....");
	}
	
	@Test(groups= {"Sanity Test","Regression Test"})
	void signUpByTwitter()
	{
		System.out.println("Sign up by Twitter....");
	}
	
	@Test(groups= {"Sanity Test"})
	void paymentReturnByBank()
	{
		System.out.println("Payment return by bank....");
	}
	
	@Test(groups= {"Regression Test"})
	void paymentInDollars()
	{
		System.out.println("Payment in dollars....");
	}
	@Test(groups= {"Sanity Test"})
	void paymentInRupees()
	{
		System.out.println("Payment in rupees...");
	}
}
