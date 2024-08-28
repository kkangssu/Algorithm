package study0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14225_부분수열의합_S1 {

	static int n;
	static int[] arr;
	static boolean[] number;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int sum = 0;
		arr = new int[n];
				
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		
		number = new boolean[sum+2];
	
		cal(0, 0);

		int notSum = 0;
		for(int i = 1; i <= sum+1; i++) {
			if(!number[i]) {
				notSum = i;
				break;
			}
		}
		
		System.out.println(notSum);
	}
	
	public static void cal(int num, int idx) {
		if(idx == n) {
			if(!number[num]) {
				number[num] = true;
				return;
			}
		}
		else if(idx < n) {
			cal(num + arr[idx], idx+1);
			cal(num, idx+1);
		}
		
	}

}
