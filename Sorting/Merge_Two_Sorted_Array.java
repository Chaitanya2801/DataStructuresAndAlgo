package lec21;

import java.util.Scanner;

public class Merge_Two_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[m];
		for(int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		for(int j = 0; j < m; j++) {
			arr2[j] = sc.nextInt();
		}
		int[] ans = new int[n+m];
		Merge(arr1, arr2, ans);
		for(int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}
	
	public static int[] Merge(int[] arr1, int[] arr2, int[] ans) {
		int n = arr1.length;
		int m = arr2.length;
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < n && j < m) {
			if(arr1[i] < arr2[j]) {
				ans[k] = arr1[i];
				i++;
				k++;
			} else {
				ans[k] = arr2[j];
				j++;
				k++;
			}
		}
		while(i < n) {
			ans[k] = arr1[i];
			i++;
			k++;
		}
		while(j < m) {
			ans[k] = arr2[j];
			j++;
			k++;
		}
		return ans;
	}

}
