package lec23;

public class Odd_Even {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 57;
		check(n);
	}
	
	public static void check(int n) {
		if((n & 1) == 1) {
			System.out.println("odd");
		} else {
			System.out.println("even");
		}
	}
 
}
