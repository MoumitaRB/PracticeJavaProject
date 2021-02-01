package Day7;

public class MethodOverloadingwithThis {
	
		int a;
		int b; 
		double c;
		
		
		
		void sum()          //first method without parameters
		{
			
		 a=10;
		 b=20;
		 System.out.println(a+b);
		}
		
		void sum(int a,int b)     //second method with 2 parameters
		{
			this.a =a;
			this.b= b;
			System.out.println(a+b);
		
		}
		void sum(int a,int b, int c)  //third method with 3 parameters
		{
			
			System.out.println(a+b+c);
				
		}
		
		 void sum(int x, double y)   //fourth method with 2 parameters and different datatype
		 {
			
			 System.out.println(x+y);
		 }
		
		
		
	
	public static void main(String[] args) {
		
		MethodOverloadingwithThis mo=new MethodOverloadingwithThis();
		mo.sum();
		mo.sum(100, 5000);
		mo.sum(90, 78, 100);
		mo.sum(120, 67.50);

	}

}
