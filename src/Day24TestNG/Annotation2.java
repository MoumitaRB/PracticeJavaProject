package Day24TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
1)Login --> @BeforeClass
2)Search --> @Test
3)Advsearch --> @Test
4)Recharge -->  @Test
5)Logout --> @AfterClass

 */

public class Annotation2 {

	@BeforeClass
	void login()
	{
		System.out.println("LoginTest...");
	}
		
	@Test(priority=1)
	void searchTest()
	{
		System.out.println("Search Test...");
	}

	@Test(priority=2)
	void advSearchTest() 
	{
		System.out.println("AdvSearch Test...");
	}

	@Test(priority=3)
	void rechargeTest()
	{
		System.out.println("Recharge Test...");
	}

	@AfterClass
	void logout()
	{
		System.out.println("Logout Test...");
	}

}
