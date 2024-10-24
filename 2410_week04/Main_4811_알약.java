package s10_w4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_4811_알약 {
	
	static int N;
	static long[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		while(N != 0) {
			dp = new long[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				dp[i][0] = 1;
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= i; j++) {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
			sb.append(dp[N][N]).append("\n");
			N = Integer.parseInt(br.readLine());
		}
		System.out.println(sb.toString());
	}

}
