package lec23;

public class Count_Set_Bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 84;
		System.out.println(CountSetBit(n));
		System.out.println(fastCount(n));
	}
	
	public static int CountSetBit(int n) {
		int c = 0;
		while(n>0) {
			if((n & 1) != 0) { // & operation works as remainder
				c++;
			}
			n >>= 1; // right shift works as divisor by 2
		}
		return c;
	}
	
	public static int fastCount(int n) { // Brian Kernighan's Algorithms
		int c = 0;
		while(n>0) {
			n = (n & (n - 1));
			c++;
		}
		return c;
	}

}
