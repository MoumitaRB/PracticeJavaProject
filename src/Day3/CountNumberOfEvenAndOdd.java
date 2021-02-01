package Day3;

public class CountNumberOfEvenAndOdd {

	public static void main(String[] args) {
		int num = 23456;
		int quotient=0;
		int remainder=0;
		int evenCounter=0;
		int oddCounter=0;
		
		for(int i= 0; num>0; i++)
		{
			if(num!=0)
			{
				quotient=(num/10);
				remainder=(num%10);
				
				if(remainder%2==0)
				{
					evenCounter=evenCounter+1;
					
				}
				else
				{
					oddCounter=oddCounter+1;
				}
				num=quotient;
				
			   
			}
			
			
		}
        
		System.out.println("Number of even didgits:" +evenCounter);
		System.out.println("Number of odd digits:"+ oddCounter);
		
		
	}

}
