package lec22;

import java.util.Scanner;

public class merge_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int[] sortedArray = new int[n];
		sortedArray = mergeSort(arr, 0, arr.length-1);
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
		System.out.println();
	}
	
	public static int[] mergeSort(int[] arr, int si, int ei) {
		if(si == ei) {
			int[] bs = new int[1];
			bs[0] = arr[si];
			return bs;
		}
		int mid = (ei + si) / 2;
		int[] f = mergeSort(arr, si, mid);
		int[] s = mergeSort(arr, mid+1, ei);
		return Merge(f, s);
	}
	
	public static int[] Merge(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int[] ans = new int[n + m];
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
