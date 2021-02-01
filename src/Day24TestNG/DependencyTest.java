package Day24TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {
	
	@Test(priority=1)
	void openUrl()
	{
		System.out.println("Lauching Browser and URL....");
		Assert.assertTrue(true);
	}
	@Test(priority=2, dependsOnMethods= {"openUrl"})
	void login()
	{
		System.out.println("Login Test....");
		Assert.assertTrue(true);
	}
    @Test(priority=3, dependsOnMethods= {"login"})
    void searchTest()
    {
    	System.out.println("Search Test....");
    	Assert.assertTrue(true);
    }
    @Test(priority=4, dependsOnMethods= {"searchTest"})
    void advSearchTest()
    {
    	System.out.println("Adv Search Test....");
    	Assert.assertTrue(true);
    }
    
    @Test(priority=5, dependsOnMethods= {"login","searchTest"})
    void rechargeTest()
    {
    	System.out.println("Recharge Test....");
    	Assert.assertTrue(true);
    }
    
    @Test(priority=6)
    void logoutTest()
    {
    	System.out.println("Logout Test....");
    	Assert.assertTrue(true);
    }
    
    
}
