package Day10;


public class ExceptionHandling1 {

	public static void main(String[] args) {
		try {
		
		//int a[]=null;
		//System.out.println(a.length);
		
		String s="welcome";
		System.out.println(s.length());
		
		String str="abc";
		int c=Integer.parseInt(str);
		System.out.println(c);
		
		}
		
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			System.out.println("Programe executed....");
		}
		
	}

}
