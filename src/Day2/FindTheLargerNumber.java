package Day2;

public class FindTheLargerNumber {

	public static void main(String[] args) {
		int a= 34;
		int b= 60;
		int c= 18;
		
		if((a>b)&&(a>c))
		{
			System.out.println("Large number is:"+ a);
		}
		else if((b>a) && (b>c))
		{
			System.out.println("Large number is:"+ b);
		}
		else
		{
			System.out.println("Large number is:"+ c);
		}
	}

}
