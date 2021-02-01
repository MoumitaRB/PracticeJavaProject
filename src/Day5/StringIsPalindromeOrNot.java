package Day5;

public class StringIsPalindromeOrNot {

	public static void main(String[] args) {
		String str="madam";
		String newStr="";
		
		for(int i=str.length()-1; i>=0; i--)
		{
			newStr=newStr+str.charAt(i);
			
		}
		
		if(newStr.equals(str))
		{
			System.out.println("It's a palindrome string!");
		}
		else
		{
			System.out.println("It's not a palindrome string! ");
		}
	

	}

}
