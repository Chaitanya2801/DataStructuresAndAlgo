package lec13;

public class string_demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello" + 10 + 20 + "bye");
		System.out.println(10 + 20 + "hello" + "bye"); //pehle int add fir string 
		System.out.println("hello" + (10 + 20) + "bye"); //pehle bracket mein ints add fir string
		
		String s = "codingblocks";
		int [] arr = new int [6];
		System.out.println(arr.length);//variable
		System.out.println(s.length());//function
		System.out.println(s.charAt(2));//System.out.println(arr[2]);
	}

}
