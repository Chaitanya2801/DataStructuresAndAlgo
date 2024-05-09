package lec18;

public class Sieve_Of_Eratosthenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		
		System.out.println(countPrimeSieve(n));
	}
	
	public static int countPrimeSieve(int n) {
		int[] prime = new int[n+1];
		prime[0] = prime[1] = 1;
		for(int i = 2; i*i <= n; i++) {
			if(prime[i] == 0) {
				for(int j = 2; i * j < prime.length; j++) {
					prime[i * j] = 1;
				}
			}
		}
		int ans = 0;
		for(int i = 2; i < prime.length; i++) {
			if(prime[i] == 0) {
				ans++;
			}
		}
		return ans;
	}

}
