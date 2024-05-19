package lec23;

public class set_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 84;
		int i = 3;
		int mask = n >> i;
		if((mask & 1) == 1) {
			System.out.println("set bit");
		} else {
			System.out.println("unset bit");
		}
	}

}
