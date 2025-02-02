package Algo2410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_1660_캡틴이다솜 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> tetra = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			int num = i*(i+1)*(i+2)/6;
			if(num > N) break;
			tetra.add(num);
		}
		
		int min = 0;
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i: tetra) {
			for (int j = i; j <= N; j++) {
				dp[j] = Math.min(dp[j], dp[j - i]+1);
			}
		}
		
		System.out.println(dp[N]);
		
	}

}
