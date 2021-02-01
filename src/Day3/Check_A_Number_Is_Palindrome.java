package Day3;

public class Check_A_Number_Is_Palindrome {

	public static void main(String[] args) {
		int num=121;
		String str= String.valueOf(num);
		
		int num1=121;
		int quotient=0;
		int remainder= 0;
		String reverse="";
		
		for(int i=0; num1>0; i++)
		{
			
		 if(num1!=0)
		   {
			quotient=(num1/10);
		    remainder = (num1%10);
		    num1=quotient;
		    reverse=reverse+remainder;
		     
		    if(num1==0)
		    {
		    	break;
		    }
		  }
		}
		System.out.println(reverse); 
		
		
		if(str.equals(reverse))
		{
			System.out.println("It's palindrome!");
		}
		else
		{
			System.out.println("It's not a palindrome!");
		}
		
	}

}
