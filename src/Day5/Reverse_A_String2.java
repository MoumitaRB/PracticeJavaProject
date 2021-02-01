package Day5;

public class Reverse_A_String2 {

	public static void main(String[] args) {
		String str="selenium";
		char array[]=str.toCharArray();
		char newArray[]=new char[str.length()];
		int j=0;
		String str2="";
		
		for(int i=array.length-1; i>=0; i--)
		{
			newArray[j]=array[i];
			str2=str2+newArray[j];
			j++;
		}
        System.out.print(str2);
		
	}

}
