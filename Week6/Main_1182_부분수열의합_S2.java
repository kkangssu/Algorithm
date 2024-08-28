package study0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합_S2 {
	
	public static int n;
	public static int sum;
	public static int[] num;
	public static int[] arr;
	public static boolean[] pick;
	public static int cases;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		sum = Integer.parseInt(st.nextToken());
		arr = new int[n];
		num = new int[n];
		pick = new boolean[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		seq(0, -1);
		
		System.out.println(cases);

	}
	
	public static void seq(int dp, int prev) {
		if(dp > 0) {
			int sum_arr = 0;
			for(int i = 0; i < dp; i++) {
				sum_arr += arr[i];
			}
			if(sum == sum_arr) {
				cases++;
			}
		}

		for(int i = prev+1; i < n; i++) {
			if(!pick[i]) {
				pick[i] = true;
				arr[dp] = num[i];
				seq(dp+1, i);
				pick[i] = false;
			}
		}
	}
}