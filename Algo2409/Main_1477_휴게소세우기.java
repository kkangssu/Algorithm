package Algo2409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1477_휴게소세우기 {
	
	static int N, M, L;
	static int[] rest;
	static int left, right;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		rest = new int[N+2];
		rest[0] = 0;
		rest[N+1] = L;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			rest[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(rest);
		
		BS();
		
		System.out.println(left);
	}

	static void BS() {
		left = 1;
		right = L;
		
		while(left <= right) {
			int interval = (left + right) / 2;
			int cnt = 0;
			
			for (int i = 1; i < N+2; i++) {
				int tmp = rest[i] - rest[i-1] - 1;
				cnt += tmp / interval;
			}
			
			if(cnt > M) left = interval + 1;
			else right = interval - 1;
		}
	}
}
