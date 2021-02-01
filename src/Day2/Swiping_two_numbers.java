package Day2;

public class Swiping_two_numbers {

	public static void main(String[] args) {
		int a=10;
		int b=30;
		int c;
		
		
		System.out.println("Before swiping the value of a=" + a + " and value of b="+ b);
		
		c=a;
		a=b;
		b=c;
		
		System.out.print("After swiping the value of a=" + a + " and value of b="+ b );
	}

}
