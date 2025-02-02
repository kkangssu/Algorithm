package Algo2410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_12015_가장긴증가하는부분수열2_BS {
	
	static int N, max;
	static int[] A;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		list.add(A[0]);
		for (int i = 1; i < N; i++) {
			if(A[i] > list.get(list.size()-1)) {
				list.add(A[i]);
			}
			else {
				int idx = bs(A[i]);
				list.set(idx, A[i]);
			}
		}
		System.out.println(list.size());
	}

	static int bs(int num) {
		int left = 0;
		int right = list.size();
		int mid;
		
		while(left < right) {
			mid = (left + right)/2;
			if(list.get(mid) < num) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		return left;
	}
}
