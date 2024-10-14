package s2410_w3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.PlatformLoggingMXBean;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10942_팰린드롬 {
	
	static int N, M;
	static int[] nums;
	static boolean[][] palin;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		nums = new int[N+1];
		palin = new boolean[N+1][N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		dp();
//		for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(palin[i]));
//		}
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == b) sb.append(1).append("\n");
			else sb.append(palin[a][b]? 1 : 0).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void dp() {
		palin[1][1] = palin[N][N] = true;
		for (int i = 2; i < N; i++) {
			palin[i][i] = true;
			int s = i;
			int e = i;
			boolean flag = true;
			while(true) {
				if(--s == 0) break;
				if(++e == N+1) break;
				if(!flag) {
					palin[s][e] = false;
					continue;
				}
				
				if(nums[s] != nums[e]) {
					flag = false;
					palin[s][e] = false;
					continue;
				}
				
				palin[s][e] = true;				
			}
		}
		for (int i = 2; i < N; i++) {
			int s = i;
			int e = i+1;
			boolean flag = false;
			if(nums[s] == nums[e]) {
				flag = true;
				palin[s][e] = true;
			}
			
			while(true) {
				if(--s == 0) break;
				if(++e == N+1) break;
				if(!flag) {
					palin[s][e] = false;
					continue;
				}
				
				if(nums[s] != nums[e]) {
					flag = false;
					palin[s][e] = false;
					continue;
				}
				palin[s][e] = true;				
			}
		}
	}

}
