package lec22;

import java.util.Scanner;

public class quick_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		quickSort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void quickSort(int[] arr, int si, int ei) {
		if(si >= ei) {
			return;
		}
		int idx = Partition(arr, si, ei);
		quickSort(arr, si, idx-1);
		quickSort(arr, idx+1, ei);
	}
	
	public static int Partition(int[] arr, int si, int ei) {
		int item = arr[ei];
		int idx = si;
		for (int i = si; i < ei; i++) {
			if(arr[i] <= item) {
				int temp = arr[idx];
				arr[idx] = arr[i];
				arr[i] = temp;
				idx++;	
			}
		}
		int temp = arr[idx];
		arr[idx] = arr[ei];
		arr[ei] = temp;
		return idx;
	}
}
