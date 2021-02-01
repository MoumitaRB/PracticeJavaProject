package Day6;

public class Calculation {
	
	int a;
	int b;
	
	void sum()                  // method without params and return value
	{
		System.out.println(a+b);
		
		
	}
	
	
	
	void sum1(int x, int y)      //method with params but no return value
	{
		a=x;
		b=y;
		System.out.println(x+y);
		
	}
	
	
	int sum2()                    //method without params but with return value
	{
		return (a+b);
	}

	int sum3(int x1, int y1)         //method with params and return value
	{   a=x1;
	    b=y1;
	
		return(x1+y1);
	}
	public static void main(String[] args) {
		
		Calculation cal=new Calculation();
		cal.a=10;
		cal.b=20;
//		cal.sum();
//	
//		cal.sum1(100, 200);
		
		System.out.println(cal.sum2());
		//System.out.println(c);
		
		int d=cal.sum3(230, 30);
		System.out.println(d);
		
	}

}
