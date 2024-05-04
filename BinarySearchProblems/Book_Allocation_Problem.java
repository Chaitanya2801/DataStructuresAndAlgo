package assignment4;

import java.util.Scanner;

public class Book_Allocation_Problem {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int ans = minPagesToRead(arr, m);
			System.out.println(ans);
			t--;
		}
    }
	public static int minPagesToRead(int[] pages, int m) {
		int low = getMax(pages);
		int high = getSum(pages);
		int result = -1;

		while(low <= high) {
			int mid = low + (high - low)/2;

			if(isValid(pages, m, mid)) {
				result = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}
		return result;
	}

	public static boolean isValid(int[] pages,int m, int maxPagesPerStudent) {
		int studentsRequired = 1;
		int currentPageCount = 0;

		for(int i = 0; i < pages.length; i++) {
			if(pages[i] > maxPagesPerStudent) {
				return false;
			}

			if(currentPageCount + pages[i] > maxPagesPerStudent) {
				studentsRequired++;
				currentPageCount = pages[i];
			} else {
				currentPageCount += pages[i];
			}
		}
		
		return studentsRequired <= m;
	}

	public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

}
