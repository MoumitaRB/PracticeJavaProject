package Day3;

public class Reverse_A_Number1 {

	public static void main(String[] args) {
		int num=1234;
		int quotient=0;
		int remainder=0;
		int reverse=0;
		
		for(int i=0; num>0; i++)
		{
			
		 if(num!=0)
		   {
			quotient=(num/10);
		    remainder = (num%10);
		    num=quotient;
		    reverse=(reverse*10)+remainder;
		    
		  }
		    
     	}
        System.out.println(reverse);
}
}