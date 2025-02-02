package Algo2410;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9251_LCS {
	
	static int[][] dp;
	static char[] str1;
	static char[] str2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		dp = new int[str1.length+1][str2.length+1];
		
		for (int i = 0; i < str1.length; i++) {
			for (int j = 0; j < str2.length; j++) {
				if(str1[i] != str2[j]) {
					dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
				}
				else {
					dp[i+1][j+1] = dp[i][j] + 1;
				}
			}
		}
		
		System.out.println(dp[str1.length][str2.length]);

	}

}
