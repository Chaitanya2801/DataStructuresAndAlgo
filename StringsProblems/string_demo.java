package lec13;

public class string_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S1 = "HELLO";
		String S2 = "HELLO";
		String S3 = new String("HELLO");
		String S4 = new String("HELLO");
		System.out.println(S1);
		System.out.println(S4);
		System.out.println(S1 == S2);
		System.out.println(S3 == S2);
	}

}
