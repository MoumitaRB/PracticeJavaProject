package Day5;

public class ReverseAString {

	public static void main(String[] args) {
		String str="welcome";
		String newStr="";
		
		for(int i=str.length()-1; i>=0; i--)
		{
			newStr=newStr+str.charAt(i);
		}

		System.out.println(newStr);
	}

}
