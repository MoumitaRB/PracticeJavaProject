package Day3;

public class CheckNumberIsPalindrome1 {

	public static void main(String[] args) {
		int num=121;
		int num1=121;
		int quotient=0;
		int remainder= 0;
		int reverse=0;
		
		for(int i=0; num1>0; i++)
		{
			
		 if(num1!=0)
		   {
			quotient=(num1/10);
		    remainder = (num1%10);
		    num1=quotient;
		    reverse=(reverse*10)+remainder;
		     
		  }
		}
		System.out.println(reverse); 
		
		
		if(num==reverse)
		{
			System.out.println("It's palindrome!");
		}
		else
		{
			System.out.println("It's not a palindrome!");
		}
		
	}
}
