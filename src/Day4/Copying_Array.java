package Day4;

public class Copying_Array {

	public static void main(String[] args) {
		int a[]= {10,20,30,40,50};
		int b[]= new int[a.length];
		
		for(int i =0; i<=a.length-1;i++)
		{
			b[i]=a[i];
		}
		
		
		//boolean flag=false;
		
		for(int x:b)
		{
			System.out.print(x+",");
			
			
		}
	}

}
