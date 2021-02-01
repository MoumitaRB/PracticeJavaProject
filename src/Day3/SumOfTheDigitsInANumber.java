package Day3;

public class SumOfTheDigitsInANumber {

	public static void main(String[] args) {
		int num= 1234;
	    int sum =0;
	    int quotient=0;
	    int remainder=0;
	    
	    for(int i=0; num>0; i++)
		{
			
		 if(num!=0)
		   {
			quotient=(num/10);
		    remainder = (num%10);
		    num=quotient;
		    sum=sum+remainder;
		     
		  }
		} 
       System.out.print("Sum of the digits in the number is: "+ sum);
	
	

}
}