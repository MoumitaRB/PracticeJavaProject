package Day6;

public class Student2 {

	public static void main(String[] args) {
		Student stu2=new Student();  //Assigning values through the reference variable in different class
		stu2.stuid=112;
		stu2.stuname="Himani";
		stu2.stugrade='A';
		
		stu2.dispaly();
		
		Student stu3=new Student();         //Assigning values through method in different class
		stu3.setData(113, "Arhan", 'A');
		stu3.displayInformation();
		

	}

}
