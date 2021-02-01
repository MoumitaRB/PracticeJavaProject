package Day6;

public class Student {
	
	public int stuid;
	public String stuname;
	public char stugrade;
public Student()
{
	
}
	
public Student(int id, String name, char grade)
{
	this.stuid=id;
	this.stuname=name;
	this.stugrade=grade;
}

public void setData(int id, String name, char grade)	
{
	stuid=id;
	stuname=name;
	stugrade=grade;
}

public void displayInformation()
{
    System.out.println(stuid +" "+ stuname+" " +stugrade);
}

public void dispaly()
{
	System.out.println(stuid);
	System.out.println(stuname);
	System.out.println(stugrade);
}

	public static void main(String[] args) {
//		Student stu1=new Student();      //Assigning values through reference variables in the same class(1)
//		stu1.stuid=111;
//		stu1.stuname="Prateek";
//		stu1.stugrade='A';
//		
//	    stu1.dispaly();
		
		
//		stu1.setData(111, "Prateek", 'A');    //Assigning values through method within the class(2)
//		stu1.displayInformation();
		
		
		
		Student stu4=new Student(114, "Mishtee", 'A');    //Assigning values through constructor within the class(3)
		stu4.displayInformation();
		stu4.dispaly();
	

	}

}
