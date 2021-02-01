package Day24TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * 1)Login --> @BeforeMethod
2)Search --> @Test
3)Logout --> AfterMethod
4)Login
5)Advsearch --> @Test
6)Logout
7)Login
8)Recharge --> @Test
9)Logout

 */


public class Annotation1 {
	
@BeforeMethod
void login()
{
	System.out.println(" LoginTest...");
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

@AfterMethod
void logout()
{
	System.out.println("Logout Test...");
}


}
