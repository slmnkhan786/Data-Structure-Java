package Array;

import java.util.*;

public class ConsecutiveMaxDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		int max = -10000000, min = 10000000;
		
		for (int i = 0; i < n; i++) {
			
			arr[i] = sc.nextInt();
			
			if (max < arr[i])
				max = arr[i];
			
			if (min > arr[i])
				min = arr[i];

		}

		sort(arr, max, min);
		
		int res=0;
		int cur_max=0;
		
		for(int i=1;i<n;i++)
		{
			cur_max=arr[i]-arr[i-1];
			if(cur_max>res)
				res=cur_max;
		}
		//print(arr);
		System.out.println(res);
	}

	public static void sort(int arr[], int max, int min) {
		
		int count[] = new int[max - min + 1];
		int output[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - min]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = 0; i < arr.length; i++) {
			output[count[arr[i] - min] - 1] = arr[i];
			count[arr[i] - min]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}

	}

	public static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

}
