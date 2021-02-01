package Day8;

public class ComputerTeacher extends Teacher{
	static String sub;
	
	void teaching(String sub)
	{   this.sub=sub;
		System.out.println("Teacher is teaching "+ sub+" in the college!");
		super.teaching(sub);
	}
	

	public static void main(String[] args) {
		ComputerTeacher ct=new ComputerTeacher();
		ct.teaching("computer");

	}

}
