package swea0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14229_백만개의정수정렬 {
	
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[1000000];
		for (int i = 0; i < 1000000; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(0, arr.length-1);
		
		System.out.println(arr[500000]);
		
	}

	static void quickSort(int start, int end) {
		if(start >= end) {
			return;
		}
		
		int pivot = start;
		int L = start+1;
		int R = end;
		
		while(L <= R) {
			while(L <= end && arr[L] <= arr[pivot]) {
				L++;
			}
			while(R > start && arr[R] >= arr[pivot]) {
				R--;
			}
			if(L > R) {
				swap(R, pivot);
			}
			else {
				swap(L, R);
			}
		}
		quickSort(start, R-1);
		quickSort(R+1, end);
	}

	static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
		return;
	}

}
