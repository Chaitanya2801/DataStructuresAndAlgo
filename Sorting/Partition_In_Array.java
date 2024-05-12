package lec21;

public class Partition_In_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,7,2,1,8,4,3};
		System.out.println(Partition(arr, 0, arr.length-1));
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
