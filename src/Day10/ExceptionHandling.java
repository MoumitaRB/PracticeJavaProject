package Day10;

import java.util.Scanner;

public class ExceptionHandling {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number:");
		int num=sc.nextInt();
		
		try {
			int c=num/0;
			System.out.println(c);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			System.out.println("Program executed finally...");
		}

	}

}
